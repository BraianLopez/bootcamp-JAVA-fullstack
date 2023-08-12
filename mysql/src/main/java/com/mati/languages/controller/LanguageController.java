package com.mati.languages.controller;

import com.mati.languages.entity.Language;
import com.mati.languages.service.LanguageService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@Log4j2
public class LanguageController {
    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/languages")
    public String index(@ModelAttribute("language") Language language,
                        Model model){
        model.addAttribute("languages", languageService.findAll());
        return "/language/index";
    }

    @PostMapping("/languages")
    public String addLanguage(@Valid @ModelAttribute("language") Language language,
                              BindingResult result,
                              Model model){
        if (result.hasErrors()){
            model.addAttribute("languages", languageService.findAll());
            return "/language/index";
        }

        if (!languageService.existsById(language.getId())) languageService.save(language);

        return "redirect:/languages";
    }

    @GetMapping("/languages/{id}")
    public String showLanguage(@PathVariable Long id,
                               Model model){
        Optional<Language> language = languageService.findById(id);

        if (language.isPresent())
            model.addAttribute("language", language.get());
        else
            return "redirect:/languages";

        return "/language/show";
    }

    @GetMapping("/languages/{id}/edit")
    public String editLanguage(@PathVariable Long id,
                               Model model){
        Optional<Language> language = languageService.findById(id);

        if (language.isPresent())
            model.addAttribute("language", language.get());
        else
            return "redirect:/languages";

        return "/language/edit";
    }

    @PutMapping("/languages/{id}")
    public String updateLanguage(@PathVariable Long id,
                                 @Valid @ModelAttribute("language") Language language,
                                 BindingResult result){

        if (result.hasErrors() || !languageService.existsById(id)) return "/language/edit";

        languageService.save(language);

        return "redirect:/languages/" + id;
    }

    @DeleteMapping("/languages/{id}")
    public String deleteLanguage(@PathVariable Long id){
        if (id != null && languageService.existsById(id)) languageService.deleteById(id);
        return "redirect:/languages";
    }
}

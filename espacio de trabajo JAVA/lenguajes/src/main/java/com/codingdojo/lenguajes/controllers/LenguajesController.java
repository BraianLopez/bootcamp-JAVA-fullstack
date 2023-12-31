package com.codingdojo.lenguajes.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.lenguajes.models.Lenguajes;
import com.codingdojo.lenguajes.services.LenguajesService;

import jakarta.validation.Valid;

@Controller
public class LenguajesController {
	private final LenguajesService lenguajesService;

	public LenguajesController(LenguajesService lenguajesService) {
		this.lenguajesService = lenguajesService;
	}

	@RequestMapping("/")
	public String root() {
		return "redirect:/languages";
	}

	// MUESTRA TODOS LOS LENGUAJES CREADOS HASTA EL MOMENTO
	@GetMapping("/languages")
	public String show(@ModelAttribute("language") Lenguajes lenguaje, Model viewModel) {
		List<Lenguajes> todosLenguajes = lenguajesService.todosLenguajes();
		viewModel.addAttribute("languages", todosLenguajes);
		return "languages.jsp";
	}

	// CREANDO UN LENGUAJE NUEVO
	@PostMapping("/languages")
	public String create(@Valid @ModelAttribute("language") Lenguajes language, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Lenguajes> languages = lenguajesService.todosLenguajes();
			model.addAttribute("languages", languages);
			return "languages.jsp";
		}
		lenguajesService.crearLenguajes(language);
		return "redirect:/";
	}

	// INFORMACION DE UN LENGUAJE EN ESPECÍFICO
	@GetMapping("/languages/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Lenguajes language = lenguajesService.findLanguage(id);

		if (language != null) {
			model.addAttribute("language", language);
			return "show.jsp";
		}
		return "redirect:/";
	}

	// EDITAR INFORMACION DE UN LENGUAJE
	@GetMapping("/languages/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Lenguajes language = lenguajesService.findLanguage(id);
		model.addAttribute("language", language);
		return "/edit.jsp";
	}

	@PutMapping("/languages/{id}")
	public String update(@Valid @ModelAttribute("language") Lenguajes language, BindingResult result) {
		if (result.hasErrors()) {
			return "/edit.jsp";
		}
		lenguajesService.actualizarLenguaje(language);
		return "redirect:/";
	}

	// ELIMINA UN LENGUAJE
	@DeleteMapping("/languages/{id}")
	public String destroy(@PathVariable("id") Long id) {
		lenguajesService.eliminarLenguaje(id);
		return "redirect:/";
	}
}
package com.codingdojo.dojosyninjas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojosyninjas.models.DojoModel;
import com.codingdojo.dojosyninjas.models.NinjaModel;
import com.codingdojo.dojosyninjas.services.MainService;

import jakarta.validation.Valid;

@Controller
public class NinjaController {
	
	//INYECCION DE DEPENDENCIAS
	private final MainService mainServ;

	public NinjaController(MainService service) {
		this.mainServ = service;
	}
	
	@GetMapping("/ninja/new")
	public String formNinja(@ModelAttribute("ninja") NinjaModel ninja,Model viewModel) {
		viewModel.addAttribute("dojos", mainServ.todosDojos());
		return"/ninjas/nuevoninja.jsp";
	}
	@PostMapping("/ninja/new")
	public String crearNinja(@Valid @ModelAttribute("ninja") NinjaModel ninja, BindingResult resultado,Model viewModel) {
		if (resultado.hasErrors()) {
			viewModel.addAttribute("dojos", mainServ.todosDojos());
			return "/ninjas/nuevoninja.jsp";
		}
		viewModel.addAttribute("dojos", mainServ.todosDojos());
		mainServ.crearNinja(ninja);
		return "redirect:/";
	}
}

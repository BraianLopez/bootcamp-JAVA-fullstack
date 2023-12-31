package com.codingdojo.dojosyninjas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojosyninjas.models.DojoModel;
import com.codingdojo.dojosyninjas.services.MainService;

import jakarta.validation.Valid;

@Controller
public class DojoController {

	//INYECCION DE DEPENDENCIAS
	private final MainService mainServ;

	public DojoController(MainService service) {
		this.mainServ = service;
	}

	@GetMapping("/dojos")
	public String index(Model viewModel) {
		viewModel.addAttribute("dojos", mainServ.todosDojos());
		return "/dojos/index.jsp";
	}

	@GetMapping("/dojo/new")
	public String formDojo(@ModelAttribute("dojo") DojoModel dojo) {
		return"/dojos/nuevodojo.jsp";
	}

	@PostMapping("/dojo/new")
	public String crearDojo(@Valid @ModelAttribute("dojo") DojoModel dojo, BindingResult resultado) {
		if (resultado.hasErrors()) {
			return "/dojos/nuevodojo.jsp";
		}
		
		mainServ.crearDojo(dojo);
	return "redirect:/";
	}
	@GetMapping("/dojo/{idDojo}")
	public String ninjasEnDojos(@PathVariable("idDojo") Long id, Model viewModel ) {
		viewModel.addAttribute("dojo", mainServ.unDojo(id));
		return "/dojos/showdojo.jsp";
	}
}

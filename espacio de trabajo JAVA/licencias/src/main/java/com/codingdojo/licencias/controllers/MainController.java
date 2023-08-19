package com.codingdojo.licencias.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.licencias.models.Licencia;
import com.codingdojo.licencias.models.Persona;
import com.codingdojo.licencias.services.MainService;

import jakarta.validation.Valid;

@Controller
public class MainController {

	//INYECCION DE DEPENDENCIAS
		@Autowired
		private MainService mainService;
		
		@GetMapping("/")
		public String root(Model viewModel) {
			
			List<Persona> todosUsuarios = mainService.todasPersonas();
			viewModel.addAttribute("infoUsuario", todosUsuarios);
			return "index.jsp";
		}
	
		@GetMapping("/persons/{id}")
		public String infoPersonas(@PathVariable("id") Long id, Model viewModel) {
			 Persona usuario = mainService.buscarPersona(id);
			 if(usuario==null) {
				 return "redirect:/";
			 }
			viewModel.addAttribute("infoUsuario", usuario);
			return "showinfo.jsp";
		}
		
		
		@GetMapping("/persons/new")
		public String formularioPersona(@ModelAttribute("persona") Persona persona) {		
			return "newperson.jsp";
		}
		
		
		//CREAR PERSONA
		@PostMapping("/persons/new")
		public String crearPersona(@Valid @ModelAttribute("persona") Persona persona, BindingResult resultado) {
			
			if(resultado.hasErrors()) {
				return "newperson.jsp";
			} 
			mainService.crearPersona(persona);
			
			return "redirect:/";
		}
		
		
		
		@GetMapping("/licenses/new")
		public String formularioLicencia(@ModelAttribute("licencia") Licencia licencia, Model viewModel) {
			
			//List<Persona> allUsers = mainService.allPerson();
			//viewModel.addAttribute("allUsers", allUsers);
			viewModel.addAttribute("personas", mainService.personasSinLic());
			return "newlic.jsp";
		}
		
		
		//CREAR LICENCIA
		@PostMapping("/licenses/new")
		public String crearLicencia(@Valid @ModelAttribute("licencia") Licencia licencia, 
				BindingResult resultado, Model viewModel) {
				
			if(resultado.hasErrors()) {
				viewModel.addAttribute("personas", mainService.personasSinLic());
				return "newlic.jsp";
			} 
			mainService.crearLicencia(licencia);
			
			return "redirect:/";
		}
}

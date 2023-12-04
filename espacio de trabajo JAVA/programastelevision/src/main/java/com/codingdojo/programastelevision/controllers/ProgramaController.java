package com.codingdojo.programastelevision.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.programastelevision.models.Programa;
import com.codingdojo.programastelevision.models.User;
import com.codingdojo.programastelevision.services.ProgramaService;
import com.codingdojo.programastelevision.services.UserServices;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ProgramaController {
	//INYECCION DEPENDENCIAS
		private final ProgramaService progServ;
		private final UserServices userService;
		public ProgramaController(ProgramaService pSe, UserServices uSe) {
			this.progServ = pSe;
			this.userService = uSe;
		}
		@GetMapping("/shows/new")
		public String formCrearPrograma(@ModelAttribute("programa") Programa programa, BindingResult resultado, HttpSession sesion,
				Model viewModel) {
			Long userId = (Long) sesion.getAttribute("userID");
			if (userId == null) {
				return "redirect:/";
			}
			User usuario = userService.encontrarPorId(userId);
			viewModel.addAttribute("usuario", usuario);
			return "new.jsp";
		}
		
		@PostMapping("/shows/new")
		public String crearPrograma(@Valid @ModelAttribute("programa") Programa programa, BindingResult resultado, HttpSession sesion,
				Model viewModel) {
			Long userId = (Long) sesion.getAttribute("userID");
			if (userId == null) {
				return "redirect:/";
			}

			if (resultado.hasErrors()) {
				User usuario = userService.encontrarPorId(userId);
				viewModel.addAttribute("usuario", usuario);
				return "new.jsp";
			}
			viewModel.addAttribute("programas", progServ.todosProgramas());
			progServ.crearPrograma(programa);
			return "redirect:/shows";
		}
		@GetMapping("/shows/{idPrograma}")
		public String mostrarProg(@PathVariable("idPrograma") Long idPrograma, @ModelAttribute("programa")Programa programa,
				BindingResult resultado, HttpSession sesion, Model viewModel) {
			Long userId = (Long) sesion.getAttribute("userID");
			if (userId == null) {
				return "redirect:/";
			}
			Programa unPrograma = progServ.unPrograma(idPrograma);
			
			User usuario = userService.encontrarPorId(userId);
			viewModel.addAttribute("usuario", usuario);
			viewModel.addAttribute("programa", unPrograma);
			return "show.jsp";
		}
		@GetMapping("/shows/{idPrograma}/edit")
		public String editarProg(@PathVariable("idPrograma") Long idPrograma, @ModelAttribute("programaEdit")Programa programa,
				BindingResult resultado, HttpSession sesion, Model viewModel) {
			Long userId = (Long) sesion.getAttribute("userID");
			if (userId == null) {
				return "redirect:/";
			}
			Programa unPrograma = progServ.unPrograma(idPrograma);
			User usuario = userService.encontrarPorId(userId);
			viewModel.addAttribute("usuario", usuario);
			viewModel.addAttribute("programa", unPrograma);
			return "edit.jsp";
		}
		@PutMapping("/shows/{id}/edit")
		public String editarProg(@Valid  @ModelAttribute("programaEdit")Programa programa, BindingResult resultado,@PathVariable("id") Long idPrograma, 
				 HttpSession sesion, Model viewModel) {
			Long userId = (Long) sesion.getAttribute("userID");
			if (userId == null) {
				return "redirect:/";
			}
			User usuario = userService.encontrarPorId(userId);
			if (resultado.hasErrors()) {
				viewModel.addAttribute("usuario", usuario);
				return "edit.jsp";
			}
			progServ.editarPrograma(programa);
			return "redirect:/shows";
		}
		@GetMapping("/shows/{id}/delete")
		public String borrarPrograma(@PathVariable("id") Long idPrograma) {
			progServ.borrarPrograma(idPrograma);
			return "redirect:/shows";
		}
}

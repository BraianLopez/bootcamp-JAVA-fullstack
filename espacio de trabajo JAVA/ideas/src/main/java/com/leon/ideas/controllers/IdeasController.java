package com.leon.ideas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.leon.ideas.models.IdeasModel;
import com.leon.ideas.models.UserModel;
import com.leon.ideas.services.IdeasService;
import com.leon.ideas.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class IdeasController {

	//INYECCION DE DEPENDENCIAS
	private final IdeasService ideasService;
	private final UserService userServ;

	public IdeasController(IdeasService iSer, UserService uSer) {
		this.ideasService = iSer;
		this.userServ = uSer;
	}
	
	@GetMapping("/nuevo/idea")
	public String crearIdea (Model viewModel) {
		viewModel.addAttribute("user", userServ.encontrarUserPorId());
		viewModel.addAttribute("ideas", new IdeasModel());
		return "crearideas.jsp";
	}
	
	
	@PostMapping("/nuevo/idea")
	public String crearIdea(@Valid @ModelAttribute("ideas") IdeasModel idea, BindingResult resultado,
			HttpSession sesion, Model viewModel) {
		
		// validar si la sesion del usuario esta activa
		Long userId = (Long) sesion.getAttribute("userID");
		if (userId == null) {
			return "redirect:/";
		}
		if (resultado.hasErrors()) {
			UserModel usuario = userServ.encontrarUserPorId(userId);
			viewModel.addAttribute("usuario", usuario);
			return "crearideas.jsp";
		}
		ideasService.crearIdea(idea);
		return "redirect:/ideas";
	}
}

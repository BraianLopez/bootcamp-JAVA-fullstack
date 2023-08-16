package com.leon.ideas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.leon.ideas.models.IdeasModel;
import com.leon.ideas.models.LogReg;
import com.leon.ideas.models.UserModel;
import com.leon.ideas.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {

	// INYECCION DE DEPENDENCIAS
	private final UserService userServ;
	//private final IdeasService eventService;

	public UserController(UserService uSer ) { //,IdeasService iServ
		this.userServ = uSer;
		//this.ideasService = iServ;
	}

	@GetMapping("/")
	public String raiz(Model viewModel) {
		viewModel.addAttribute("user", new UserModel());
		viewModel.addAttribute("login", new LogReg());
		return "loginreg.jsp";
	}
	
	@PostMapping("/registration")
	public String registro(@Valid @ModelAttribute("user") UserModel usuario,
			BindingResult resultado, Model viewModel ) {
		if(resultado.hasErrors()) {
			viewModel.addAttribute("login", new LogReg());
			return "loginreg.jsp";
		}
		UserModel usuarioRegistrado = userServ.registroUsuario(usuario, resultado);
		viewModel.addAttribute("login", new LogReg());
		if(usuarioRegistrado != null) {
			viewModel.addAttribute("registro", "Gracias por registrarte, ahora login por favor");
		}
		return "loginreg.jsp"; 
	} 
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("login") LogReg loginuser,
			BindingResult resultado, Model viewModel, HttpSession sesion) {
		if (resultado.hasErrors()) {
			viewModel.addAttribute("user", new UserModel());
			return "loginreg.jsp";
		}
		
		if(userServ.authenthicateUser(
				loginuser.getEmail(), 
				loginuser.getPassword(), 
				resultado )) {
			UserModel usuarioLog = userServ.encontrarPorEmail(loginuser.getEmail());
			sesion.setAttribute("userID",usuarioLog.getId());
			return "redirect:/ideas";
		}else {
			viewModel.addAttribute("errorLog", "Por favor intenta de nuevo");
			viewModel.addAttribute("user", new UserModel());
			return "loginreg.jsp";
		}
		
	}
	
	@GetMapping("/ideas")
	public String bienvenida(@ModelAttribute("ideas") IdeasModel ideas,
			BindingResult resultado,
			HttpSession sesion, Model viewModel) {
		Long userId =  (Long) sesion.getAttribute("userID");
		if(userId == null ) {
			return "redirect:/";
		}
		UserModel usuario = userServ.encontrarUserPorId(userId);
		viewModel.addAttribute("usuario", usuario);
		return "dashboard.jsp";
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession sesion) {
		sesion.setAttribute("userID", null);
		return "redirect:/";
	}
}

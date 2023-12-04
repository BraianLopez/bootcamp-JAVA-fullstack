package com.codingdojo.waterbnb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.waterbnb.models.LogReg;

import com.codingdojo.waterbnb.models.User;
import com.codingdojo.waterbnb.services.UserServices;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	// INYECCION DEPENDENCIAS
	private final UserServices userService;
	
	public UserController(UserServices uSe) {
		this.userService = uSe;
	}

	@GetMapping("/guest/signin")
	public String raiz(Model viewModel) {
		viewModel.addAttribute("user", new User());
		viewModel.addAttribute("login", new LogReg());
		return "/loginreg.jsp";
	}

	@PostMapping("/registration")
	public String registro(@Valid @ModelAttribute("user") User usuario, BindingResult resultado, Model viewModel) {
		if (resultado.hasErrors()) {
			// viewModel.addAttribute("user", new user()); NO SE ENVIA UNA INSTANCIA VACIA DE USER PORQUE SE PIERDE LA REFERENCIA A LOS ERRORES
			viewModel.addAttribute("login", new LogReg());
			return "/loginreg.jsp";
		}
		User usuarioRegistrado = userService.registroUsuario(usuario, resultado);
		if (usuarioRegistrado != null) {
			viewModel.addAttribute("registro", "gracias por registrarte, ahora inicia sesion");
		}
		 viewModel.addAttribute("login", new LogReg());
		return "loginreg.jsp";
	}

	@PostMapping("/login")
	public String iniciarSesion(@Valid @ModelAttribute("login") LogReg loginUser, BindingResult resultado,
			Model viewModel, HttpSession sesion) {
		if (resultado.hasErrors()) {
			viewModel.addAttribute("user", new User());
			return "/loginreg.jsp";
		}
		if (userService.autenticarUsuario(loginUser.getEmail(), loginUser.getPassword(), resultado)) {
			User usuarioLog = userService.encontrarPorEmail(loginUser.getEmail());
			sesion.setAttribute("userID", usuarioLog.getId());
			if(usuarioLog.getRol().equals(1)) {
			return "redirect:/host/dashboard";
			}else {
				return "redirect:/";
			}
		}
		viewModel.addAttribute("errorLog", "Por favor intenta de nuevo");
		viewModel.addAttribute("user", new User());
		return "/loginreg.jsp";
	}

	

	
	@GetMapping("/logout")
	public String cerrarSesion(HttpSession sesion) {
		sesion.setAttribute("userID", null);
		return "redirect:/";
	}

}

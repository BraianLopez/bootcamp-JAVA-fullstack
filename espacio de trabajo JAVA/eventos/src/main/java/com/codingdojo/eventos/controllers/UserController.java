package com.codingdojo.eventos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.eventos.models.Eventos;
import com.codingdojo.eventos.models.LogReg;
import com.codingdojo.eventos.models.Provincias;
import com.codingdojo.eventos.models.User;
import com.codingdojo.eventos.services.EventoService;
import com.codingdojo.eventos.services.UserServices;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	// INYECCION DEPENDENCIAS
	private final UserServices userService;
	private final EventoService eventoService;
	public UserController(UserServices uSe, EventoService eSer) {
		this.userService = uSe;
		this.eventoService = eSer;
	}

	@GetMapping("/")
	public String raiz(Model viewModel) {
		viewModel.addAttribute("user", new User());
		viewModel.addAttribute("login", new LogReg());
		viewModel.addAttribute("provincias", Provincias.provincias);
		return "/loginreg.jsp";
	}

	@PostMapping("/registration")
	public String registro(@Valid @ModelAttribute("user") User usuario, BindingResult resultado, Model viewModel) {
		if (resultado.hasErrors()) {
			// viewModel.addAttribute("user", usuario);
			viewModel.addAttribute("login", new LogReg());
			viewModel.addAttribute("provincias", Provincias.provincias);
			return "/loginreg.jsp";
		}
		User usuarioRegistrado = userService.registroUsuario(usuario, resultado);
		if (usuarioRegistrado != null) {
			viewModel.addAttribute("registro", "gracias por registrarte, ahora inicia sesion");
		}
		// sobreescribian info
		// viewModel.addAttribute("user", new User());
		// viewModel.addAttribute("login", new LogReg());
		return "loginreg.jsp";
	}

	@PostMapping("/login")
	public String iniciarSesion(@Valid @ModelAttribute("login") LogReg loginUser, BindingResult resultado,
			Model viewModel, HttpSession sesion) {
		if (resultado.hasErrors()) {
			viewModel.addAttribute("user", new User());
			viewModel.addAttribute("provincias", Provincias.provincias);
			// viewModel.addAttribute("login", new LogReg());
			return "/loginreg.jsp";
		}
		if (userService.autenticarUsuario(loginUser.getEmail(), loginUser.getPassword(), resultado)) {
			User usuarioLog = userService.encontrarPorEmail(loginUser.getEmail());
			sesion.setAttribute("userID", usuarioLog.getId());
			return "redirect:/events";
		}
		viewModel.addAttribute("errorLog", "Por favor intenta de nuevo");
		viewModel.addAttribute("user", new User());
		viewModel.addAttribute("provincias", Provincias.provincias);
		// viewModel.addAttribute("login", new LogReg());
		return "/loginreg.jsp";
	}

	@GetMapping("/events")
	public String bienvenida( @ModelAttribute("evento")Eventos evento, BindingResult result, HttpSession sesion, Model viewModel) {
		Long userId = (Long) sesion.getAttribute("userID");
		if (userId == null) {
			return "redirect:/";
		}
		User usuario = userService.encontrarPorId(userId);
		viewModel.addAttribute("usuario", usuario);
		viewModel.addAttribute("provincias", Provincias.provincias);
		viewModel.addAttribute("eventosProvinciaUser", eventoService.eventoProvinciaUsuario(usuario.getProvincia()));
		viewModel.addAttribute("eventosNoProvinciaUser", eventoService.eventoNoProvinciaUsuario(usuario.getProvincia()));
		return "/dashboard.jsp";
	}

	
	@GetMapping("/logout")
	public String cerrarSesion(HttpSession sesion) {
		sesion.setAttribute("userID", null);
		return "redirect:/";
	}

}

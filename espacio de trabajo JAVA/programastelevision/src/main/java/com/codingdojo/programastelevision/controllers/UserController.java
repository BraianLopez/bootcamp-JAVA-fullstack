package com.codingdojo.programastelevision.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.programastelevision.models.LogReg;
import com.codingdojo.programastelevision.models.User;
import com.codingdojo.programastelevision.services.ProgramaService;
import com.codingdojo.programastelevision.services.UserServices;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	// INYECCION DEPENDENCIAS
	private final UserServices userService;
	private final ProgramaService progServ;
	public UserController(UserServices uSe, ProgramaService pSer) {
		this.userService = uSe;
		this.progServ = pSer;
	}

	@GetMapping("/")
	public String raiz(Model viewModel) {
		viewModel.addAttribute("user", new User());
		viewModel.addAttribute("login", new LogReg());
		return "/loginreg.jsp";
	}

	@PostMapping("/registration")
	public String registro(@Valid @ModelAttribute("user") User usuario, BindingResult resultado, Model viewModel) {
		//ERRORES VALIDACION DEL MODELO
		if (resultado.hasErrors()) {
			viewModel.addAttribute("login", new LogReg());
			return "loginreg.jsp";
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
			return "redirect:/shows";
		}
		viewModel.addAttribute("errorLog", "Por favor intenta de nuevo");
		viewModel.addAttribute("user", new User());
		return "/loginreg.jsp";
	}

	@GetMapping("/shows")
	public String bienvenida(HttpSession sesion, Model viewModel) {
		Long userId = (Long) sesion.getAttribute("userID");
		if (userId == null) {
			return "redirect:/";
		}
		User usuario = userService.encontrarPorId(userId);
		viewModel.addAttribute("usuario", usuario);
		viewModel.addAttribute("programas", progServ.todosProgramas());
		return "dashboard.jsp";
	}

	@GetMapping("/logout")
	public String cerrarSesion(HttpSession sesion) {
		sesion.setAttribute("userID", null);
		return "redirect:/";
	}

}

package com.codingdojo.cursosplataforma.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.cursosplataforma.models.Curso;
import com.codingdojo.cursosplataforma.models.LogReg;
import com.codingdojo.cursosplataforma.models.User;
import com.codingdojo.cursosplataforma.services.CursoService;
import com.codingdojo.cursosplataforma.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {

	// INYECCION DE DEPENDENCIAS
	private final UserService userServ;
	private final CursoService cursoService;
	//private final IdeasService eventService;

	public UserController(UserService uSer, CursoService iServ ) { //,IdeasService iServ
		this.userServ = uSer;
		this.cursoService = iServ;
	}

	@GetMapping("/")
	public String raiz(Model viewModel) {
		viewModel.addAttribute("user", new User());
		viewModel.addAttribute("login", new LogReg());
		return "loginreg.jsp";
	}
	
	@PostMapping("/registration")
	public String registro(@Valid @ModelAttribute("user") User usuario,
			BindingResult resultado, Model viewModel ) {
		if(resultado.hasErrors()) {
			viewModel.addAttribute("login", new LogReg());
			return "loginreg.jsp";
		}
		User usuarioRegistrado = userServ.registroUsuario(usuario, resultado);
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
			viewModel.addAttribute("user", new User());
			return "loginreg.jsp";
		}
		
		if(userServ.authenthicateUser(
				loginuser.getEmail(), 
				loginuser.getPassword(), 
				resultado )) {
			User usuarioLog = userServ.encontrarPorEmail(loginuser.getEmail());
			sesion.setAttribute("userID",usuarioLog.getId());
			return "redirect:/ideas";
		}else {
			viewModel.addAttribute("errorLog", "Por favor intenta de nuevo");
			viewModel.addAttribute("user", new User());
			return "loginreg.jsp";
		}
		
	}
	
	@GetMapping("/ideas")
	public String bienvenida(@ModelAttribute("curso") Curso curso,
			BindingResult resultado,
			HttpSession sesion, Model viewModel) {
		Long userId =  (Long) sesion.getAttribute("userID");
		if(userId == null ) {
			return "redirect:/";
		}
		User usuario = userServ.encontrarPorId(userId);
		viewModel.addAttribute("usuario", usuario);
		
		List<Curso> todosCursos = cursoService.todosCursos();
		viewModel.addAttribute("cursos", todosCursos);
		return "dashboard.jsp";
		
	}
	@GetMapping("/logout")
	public String cerrarSesion(HttpSession sesion) {
		sesion.setAttribute("userID", null);
		return "redirect:/";
	}
	
	
}

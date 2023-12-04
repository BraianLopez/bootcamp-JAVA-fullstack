package com.codingdojo.cursosplataforma.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.cursosplataforma.models.Curso;
import com.codingdojo.cursosplataforma.models.User;
import com.codingdojo.cursosplataforma.services.CursoService;
import com.codingdojo.cursosplataforma.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class CursoController {
	private final CursoService cursoServ;
	private final UserService userServ;
	public CursoController(CursoService cSe, UserService uSe) {
		this.cursoServ = cSe;
		this.userServ = uSe; 
	}

	
	@GetMapping("/courses/new")
	public String formCrearCurso(@ModelAttribute("curso") Curso curso, BindingResult resultado, HttpSession sesion,
			Model viewModel) {
		Long userId = (Long) sesion.getAttribute("userID");
		if (userId == null) {
			return "redirect:/";
		}

		User usuario = userServ.encontrarPorId(userId);
		viewModel.addAttribute("usuario", usuario);
		return "newcourse.jsp";
	}
	@PostMapping("/courses/new")
	public String crearCurso(@Valid @ModelAttribute("curso") Curso curso, BindingResult resultado, HttpSession sesion,
			Model viewModel) {
		Long userId = (Long) sesion.getAttribute("userID");
		if (userId == null) {
			return "redirect:/";
		}

		if (resultado.hasErrors()) {
			User usuario = userServ.encontrarPorId(userId);
			viewModel.addAttribute("usuario", usuario);
			return "newcourse.jsp";
		}
		cursoServ.crearCurso(curso);
		return "redirect:/courses";
	}
}

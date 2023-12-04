package com.codingdojo.examenblackbelt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.examenblackbelt.models.Course;
import com.codingdojo.examenblackbelt.models.User;
import com.codingdojo.examenblackbelt.services.CoursesService;
import com.codingdojo.examenblackbelt.services.UserServices;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class CoursesController {
	
	private final CoursesService coursesServ;
	private final UserServices userServ;
	public CoursesController(CoursesService cSe, UserServices uSe) {
		this.coursesServ = cSe;
		this.userServ = uSe; 
	}

	
	@GetMapping("/courses/new")
	public String formCrearCurso(@ModelAttribute("curso") Course curso, BindingResult resultado, HttpSession sesion,
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
	public String crearCurso(@Valid @ModelAttribute("curso") Course curso, BindingResult resultado, HttpSession sesion,
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
		coursesServ.crearCurso(curso);
		return "redirect:/courses";
	}
}

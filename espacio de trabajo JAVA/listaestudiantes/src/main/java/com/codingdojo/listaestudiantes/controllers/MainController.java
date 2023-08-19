package com.codingdojo.listaestudiantes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.listaestudiantes.models.ContactInfo;
import com.codingdojo.listaestudiantes.models.Student;
import com.codingdojo.listaestudiantes.services.MainService;

import jakarta.validation.Valid;

@Controller
public class MainController {

	// INYECCION DE DEPENDENCIAS
	@Autowired
	private MainService mainService;

	@GetMapping("/")
	public String root() {
		return "redirect:/students";
	}

	@GetMapping("/students")
	public String studentsInfo(Model viewModel) {

		List<Student> todosEstudiantes = mainService.todosEstudiantes();
		viewModel.addAttribute("todos", todosEstudiantes);
		return "showinfo.jsp";
	}

	@GetMapping("/students/new")
	public String formStudent(@ModelAttribute("estudiante") Student student) {
		return"studentnew.jsp";
	}
	@PostMapping("/students/new")
	public String formStudent(@Valid @ModelAttribute("estudiante") Student student, BindingResult resultado) {
		if(resultado.hasErrors()) {
		return"studentnew.jsp";
	}
		mainService.createStudent(student);
		return "redirect:/";
	}
	@GetMapping("/contact/new")
	public String formContactInfo(@ModelAttribute("contactinfo") ContactInfo contactInfo, Model viewModel) {	
		viewModel.addAttribute("estudiantes", mainService.studentSinContactInfo());
		return "contactnew.jsp";
	}
	
	
	//CREAR CONTACT INFO
	@PostMapping("/contact/new")
	public String formContactInfo(@Valid @ModelAttribute("contactinfo") ContactInfo contactInfo, 
			BindingResult resultado, Model viewModel) {
			
		if(resultado.hasErrors()) {
			viewModel.addAttribute("estudiantes", mainService.studentSinContactInfo());
			return "contactnew.jsp";
		} 
		mainService.createContactInfo(contactInfo);
		
		return "redirect:/";
	}
}
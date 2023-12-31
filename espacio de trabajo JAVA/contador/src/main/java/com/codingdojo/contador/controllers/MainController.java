package com.codingdojo.contador.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
//@RequestMapping("/")
public class MainController {

	//METODOS DE CLASE
	private void setContadorSesion(HttpSession sesion, int numeroVeces) {
		sesion.setAttribute("contador", numeroVeces);
	}
	
	private int getContadorSesion(HttpSession sesion) {
		Object valorSesion = sesion.getAttribute("contador");
		if (valorSesion == null) {
			setContadorSesion(sesion, 0);
			valorSesion = sesion.getAttribute("contador");
			}
		return (Integer) valorSesion;
	}
	
//	@GetMapping("/")
//	public void index() {
//		Redirect(/your_server);
//	}
	@GetMapping("/your_server")
	public String index(HttpSession sesion) {
		System.out.println(sesion.getAttribute("contador"));
		int conteoActual = getContadorSesion(sesion);
		System.out.println(sesion.getAttribute("contador"));
		setContadorSesion(sesion, conteoActual + 1);
		return "index.jsp";
	}
	
	@GetMapping("/your_server/contador")
	public String contador(HttpSession sesion, Model modelo) {
		modelo.addAttribute("contador", getContadorSesion(sesion));
		return "contador.jsp";
	}
	@GetMapping("/reset")
	public String reset(HttpSession s) {
		s.invalidate();
		return "redirect:/your_server/contador";
	}
}

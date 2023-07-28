package com.codingdojo.ninjagold.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String irRaiz() {
		return "redirect:/gold";
	}
	
	@GetMapping("/gold")
	public String raiz() {
		return "index.jsp";
	}
	
	@PostMapping("/gold")
	public String enviarOro(HttpSession sesion, @RequestParam(value="lugar") String lugar) {
		
		 //variables inicio
		int oro = 0;
		
		//iniciar la clave gold
		if(sesion.getAttribute("gold")== null) {
			sesion.setAttribute("gold", oro);
		}
		else {
			oro=(int) sesion.getAttribute("gold");
		}
		
		
		
		
		return "redirect:/gold";
	}
}


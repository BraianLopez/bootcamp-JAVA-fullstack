package com.codingdojo.usoplantillas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/root")

public class MainController {

	
	@RequestMapping("/primeraplantilla")
	public String raiz(Model modelo) {
		
		//variable del metodo raiz
		String nombre = "Grace Hopper";
		String itemName = "Cooper wire";
		double precio = 5.75;
		String description = "Grace Hopper";
		
		
		//
		modelo.addAttribute("name", nombre);
		modelo.addAttribute("itemNombre", itemName);
		modelo.addAttribute("price", precio);
		modelo.addAttribute("desc", description);
		return "HolaMundo.html";
	}
}

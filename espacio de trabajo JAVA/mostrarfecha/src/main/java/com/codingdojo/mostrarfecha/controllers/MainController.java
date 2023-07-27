package com.codingdojo.mostrarfecha.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	
	@RequestMapping("/")
	public String home() {
		return "index.jsp";				
	}
//	@RequestMapping("/date")
//	public String fecha(Model modelo) {
//		
//		return "date.jsp";				
//	}
//	@RequestMapping("/")
//	public String hora(Model modelo) {
//		return "time.jsp";				
//	}
}

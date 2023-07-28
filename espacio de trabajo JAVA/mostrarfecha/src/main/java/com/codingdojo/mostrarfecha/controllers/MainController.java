package com.codingdojo.mostrarfecha.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	
	@RequestMapping("/")
	public String home() {
		return "index.jsp";				
	}
	@GetMapping("/date")
	public String fecha(Model modelo) {		SimpleDateFormat fecha = new SimpleDateFormat ("EEEE, MMM d, yyyy");
		Date date = new Date();
		modelo.addAttribute("fecha", fecha.format(date));
		return "date.jsp";				
	}
	@GetMapping("/time")
	public String hora(Model modelo) {
		SimpleDateFormat hora = new SimpleDateFormat ("h:mm a");
		Date date = new Date();
		modelo.addAttribute("hora", hora.format(date));
		return "time.jsp";				
	}
}

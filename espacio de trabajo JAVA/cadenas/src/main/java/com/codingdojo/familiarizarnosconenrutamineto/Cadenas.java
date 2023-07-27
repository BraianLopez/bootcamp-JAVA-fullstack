package com.codingdojo.familiarizarnosconenrutamineto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cadenas {
	@RequestMapping("/")
	public String saludar() {
		return "Hola cliente! ¿Como estas?";
	}
	@RequestMapping("/random")
	public String infoSpring() {
		return "¡SpringBoot es genial!";
	}
	

}

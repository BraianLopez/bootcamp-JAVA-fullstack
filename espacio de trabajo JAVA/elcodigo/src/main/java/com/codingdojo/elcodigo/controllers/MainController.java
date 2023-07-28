package com.codingdojo.elcodigo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	
	
	@RequestMapping(value="/verificar", method=RequestMethod.POST)
	public String validar(@RequestParam(value="password") String codigo, RedirectAttributes rAtt) {
	if (!codigo.equals("bushido")) {
		rAtt.addFlashAttribute("error1","Por favor, intenta mas fuerte");
		return "redirect:/";
	}
	return "redirect:/code";
	}
	@RequestMapping("/code")
	public String code(Model modelo) {
		String [] datos= {"Loyalty","Coraje","Veracity","Compassion","Honor"};
		modelo.addAttribute("arreglo", datos);
		return "code.jsp";
	}
}

package com.codingdojo.famconenrut;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodingController {
	@RequestMapping("/coding")
	public String coding() {
		return "Hola Coding Dojo!";
	}
	@GetMapping("/coding/python")
	public String python() {
		return "Python/Django fue increible!";
	}
	@GetMapping("/coding/java")
	public String java() {
		return "Java/Spring es mejor!";
	}
	}



package com.codingdojo.holahumano.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HolaHumano {

		  @RequestMapping("/")
		    public String index(@RequestParam(value="q", required=false) String nombre) {
		      if(nombre==null) {
		    	  return "Hello Human";
		      }
			  return "Hello "+ nombre ;
		    }
		//	}
//	@GetMapping("/coding/python")
//	public String python() {
//		return "Hello ";
//	}
//	@GetMapping("/coding/java")
//	public String java() {
//		return "Java/Spring es mejor!";
}


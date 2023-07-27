package com.codingdojo.famconenrut;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {

	
	@GetMapping("/m/{track}")
	public String showLesson(@PathVariable("track") String track) {
		if(track.contentEquals("dojo")) {
			return "El Dojo es increible!";
		} else if(track.contentEquals("burbank-dojo")) {
			return "El Dojo Burbank está localizado al sur de California";
		} else if(track.contentEquals("san-jose")) {
			return "El Dojo SJ es el cuartel general";
		}
		System.out.println("hola desde dojo");
		return track;
	}
	
}

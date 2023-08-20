package com.codingdojo.productosycategorias.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.codingdojo.productosycategorias.models.CategoryModel;
import com.codingdojo.productosycategorias.models.ProductModel;
import com.codingdojo.productosycategorias.services.MainService;

@Controller
public class MainController {
	// INYECCION DE DEPENDECIAS
		private final MainService mainServ;
		public MainController(MainService service) {
			this.mainServ = service;
		}
	@GetMapping("/")
	public String root(Model modelo) {
		List<ProductModel> todosProductos = mainServ.todosProductos();
		modelo.addAttribute("productos", todosProductos);
		return "index.jsp";
	}
	
}
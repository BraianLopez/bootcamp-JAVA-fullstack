package com.codingdojo.productosycategorias.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.productosycategorias.models.CategoryModel;
import com.codingdojo.productosycategorias.models.ProductCategoryModel;
import com.codingdojo.productosycategorias.models.ProductModel;
import com.codingdojo.productosycategorias.services.MainService;

import jakarta.validation.Valid;

@Controller
public class CategoryController {
	// INYECCION DE DEPENDECIAS
		private final MainService mainServ;
		public CategoryController(MainService service) {
			this.mainServ = service;
		}
		
		@GetMapping("/categories/new")
		public String formProduct(@ModelAttribute("categoria") CategoryModel categoria) {
			return "nuevacategoria.jsp";
		}
		
		@PostMapping("/categories/new")
		public String nuevoProduct(@Valid @ModelAttribute("categoria") CategoryModel categoria, 
				BindingResult resultado) {
			if (resultado.hasErrors()) {

				return "nuevacategoria.jsp";
			}
			mainServ.crearCategoria(categoria);
			return "redirect:/";
		}
		@GetMapping("/categories/{idCat}")
		public String mostrarProducto(@PathVariable("idCat") Long idCat,
				@ModelAttribute("asociacion") ProductCategoryModel asociacion,
				Model modelo) {
			CategoryModel categoria = mainServ.unaCategoria(idCat);
			modelo.addAttribute("productos", mainServ.categoriaSinProducto(categoria));
			modelo.addAttribute("categoria",categoria);
			return "mostrarcategoria.jsp";
		}
}

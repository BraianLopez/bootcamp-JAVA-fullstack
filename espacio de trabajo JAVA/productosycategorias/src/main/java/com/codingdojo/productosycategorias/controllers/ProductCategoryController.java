package com.codingdojo.productosycategorias.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.productosycategorias.models.ProductCategoryModel;
import com.codingdojo.productosycategorias.services.MainService;

@Controller
public class ProductCategoryController {

	// INYECTAR DEPENDECIAS
	private final MainService mainServ;

	public ProductCategoryController(MainService mainS) {
		this.mainServ = mainS;
	}

	@PostMapping("/aso/{idProducto}")
	public String asociarProductoCategoria(@PathVariable("idProducto") Long idProducto,
			@ModelAttribute("asociacion") ProductCategoryModel productosCategorias, BindingResult resultado,
			Model viewModel) {

		if (resultado.hasErrors()) {
			return "mostrarproducto.jsp";
		}
		mainServ.crearVinculo(productosCategorias);
		return "redirect:/product/"+idProducto;

	}

}

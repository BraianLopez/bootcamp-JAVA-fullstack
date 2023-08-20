package com.codingdojo.productosycategorias.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.productosycategorias.models.CategoryModel;
import com.codingdojo.productosycategorias.models.ProductCategoryModel;
import com.codingdojo.productosycategorias.models.ProductModel;
import com.codingdojo.productosycategorias.repositories.CategoryRepo;
import com.codingdojo.productosycategorias.repositories.ProductCategoryRepo;
import com.codingdojo.productosycategorias.repositories.ProductRepo;

@Service
public class MainService {

	// INYECCION DE DEPENDECIAS
		private final ProductRepo productRepo;
		private final CategoryRepo categoryRepo;
		private final ProductCategoryRepo proCatRepo;
		public MainService(ProductRepo pRe, CategoryRepo cRe, ProductCategoryRepo pCRe) {
			this.productRepo = pRe;
			this.categoryRepo = cRe;
			this.proCatRepo = pCRe;
		}
		
		
		//METODOS PARA CREAR
		public ProductModel crearProducto(ProductModel producto) {
			return productRepo.save(producto);
		}
		public CategoryModel crearCategoria(CategoryModel categoria) {
			return categoryRepo.save(categoria);
		}
		public ProductCategoryModel crearVinculo(ProductCategoryModel productoCategorias) {
			return proCatRepo.save(productoCategorias);
		}
		
		//metodos lectura
		public List<CategoryModel> productoSinCategoria(ProductModel producto){
			return categoryRepo.findByProductsNotContains(producto);
		}
		public ProductModel unProducto(Long id) {
			return productRepo.findById(id).orElse(null);
		}
		public List<ProductModel> todosProductos() {
			return productRepo.findAll();
		}
		public List<ProductModel> categoriaSinProducto(CategoryModel categoria){
			return productRepo.findByCategoriesNotContains(categoria);
		}
		public CategoryModel unaCategoria(Long id) {
			return categoryRepo.findById(id).orElse(null);
		}
}

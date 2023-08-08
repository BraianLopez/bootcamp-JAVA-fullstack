package com.codingdojo.productosycategorias.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.productosycategorias.models.ProductModel;


public interface ProductRepo extends CrudRepository<ProductModel, Long>{
	

}
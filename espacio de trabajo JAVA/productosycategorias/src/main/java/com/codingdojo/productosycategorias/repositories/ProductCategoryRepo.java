package com.codingdojo.productosycategorias.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.productosycategorias.models.ProductCategoryModel;

public interface ProductCategoryRepo extends CrudRepository<ProductCategoryModel,Long>{
	

}
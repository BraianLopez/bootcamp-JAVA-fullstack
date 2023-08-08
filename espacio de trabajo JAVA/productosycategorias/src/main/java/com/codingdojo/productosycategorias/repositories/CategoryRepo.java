package com.codingdojo.productosycategorias.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.productosycategorias.models.CategoryModel;
import com.codingdojo.productosycategorias.models.ProductModel;

public interface CategoryRepo extends CrudRepository<CategoryModel, Long>{

	List<CategoryModel> findByProductsNotContains(ProductModel producto);
}
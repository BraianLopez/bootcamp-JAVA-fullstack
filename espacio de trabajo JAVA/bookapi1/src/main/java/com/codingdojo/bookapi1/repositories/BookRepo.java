package com.codingdojo.bookapi1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.bookapi1.models.BookModel;
@Repository
public interface BookRepo  extends CrudRepository<BookModel, Long>{
	//ESTE METODO RECUPERA TODOS LOS LIBROS DE LA BASE DE DATOS
    List<BookModel> findAll();
    //ESTE METODO RECUPERA UN LIBRO POR SU DESCRIPCION
    List<BookModel> findByDescriptionContaining(String search);
    //ESTE METODO CUENTA CUANTOS LIBROS HAY EN UNA CADENA POR SU TITULO
    Long countByTitleContaining(String search);
    //ESTE METODO BORRA UN LIBRO QUE EMPIEZA CON UN TITULO ESPECIFICO 
    Long deleteByTitleStartingWith(String search);

}

package com.codingdojo.bookapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.bookapi.models.BookModel;
import com.codingdojo.bookapi.repositories.BookRepo;
@Service
public class BookService {
//  //Agregando el book al repositorio como una dependencia
//  private final BookRepo BookRepo;
//
//  public BookService(BookRepo BookRepo) {
//      this.BookRepo = BookRepo;
//  }

  @Autowired
  private BookRepo bookrepo;

  //Devolviendo todos los libros.
  public List<BookModel> allBooks() {
      return bookrepo.findAll();
  }
  //Creando un libro.
  public BookModel createBook(BookModel b) {
      return bookrepo.save(b);
  }
  //Obteniendo la información de un libro
  public BookModel findBook(Long id) {
      Optional<BookModel> optionalBook = bookrepo.findById(id);
      if(optionalBook.isPresent()) {
          return optionalBook.get();
      } else {
          return null;
      }
  }
  
  //ACTUALIZAR INFORMACION
  public BookModel actualizarLibro(BookModel libro) {
	  BookModel temporal = findBook(libro.getId());
	  temporal.setDescription(libro.getDescription());
	  temporal.setLanguage(libro.getLanguage());
	  temporal.setNumberOfPages(libro.getNumberOfPages());
	  temporal.setTitle(libro.getTitle());
	   return bookrepo.save(temporal);
	  
  }
  
}


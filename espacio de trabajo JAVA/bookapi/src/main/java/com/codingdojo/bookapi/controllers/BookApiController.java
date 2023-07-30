package com.codingdojo.bookapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.bookapi.models.BookModel;
import com.codingdojo.bookapi.services.BookService;

@RestController
public class BookApiController {
	
//	    //INYECCION DEPENDENCIAS 
//	    private final BookService bookService;
//	    public BooksApi(BookService bookService){
//	        this.bookService = bookService;
//	    }

	    @Autowired
	    private BookService bookservice;


	    @GetMapping("/api/books")
	    public List<BookModel> index() {
	        return bookservice.allBooks();
	    }
//CREAR UN NUEVO LIBRO
	    @PostMapping(value="/api/books")
	    public BookModel create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
	        BookModel book = new BookModel(title, desc, lang, numOfPages);
	        return bookservice.createBook(book);
	    }
//MOSTRAR INFORMACION DE UN LIBRO ESPECIFICO
	    @GetMapping("/api/books/{id}")
	    public BookModel show(@PathVariable("id") Long id) {
	        BookModel book = bookservice.findBook(id);
	        return book;
	    }

//ACTUALIZAR INFORMACION DE UN LIBRO ESPECIFICO
	    @PutMapping("/api/books/{id}")
	    public BookModel actualizar(@PathVariable("id")Long id,
	    	@RequestParam(value="title") String title,
	    	@RequestParam(value="description") String desc,
	    	@RequestParam(value="language") String lang,
	    	@RequestParam(value="title") Integer numberOfPages) {
	    	return actualizar(id,title,desc,lang,numberOfPages);
	    }

}
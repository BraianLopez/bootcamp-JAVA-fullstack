package com.codingdojo.bookapi1.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.bookapi1.models.BookModel;
import com.codingdojo.bookapi1.services.BookService;

import jakarta.validation.Valid;

@Controller
public class LibrosController {
	 private final BookService bookService;
	    
	    public LibrosController(BookService bookService) {
	        this.bookService = bookService;
	    }
	    //MUESTRA TODOS LOS LIBROS CREADOS HASTA EL MOMENTO
	    @RequestMapping("/books")
	    public String index(Model model) {
	        List<BookModel> books = bookService.allBooks();
	        model.addAttribute("books", books);
	        return "/books/index.jsp";
	    }
	    
	    //CREAR UN LIBRO NUEVO
	    @RequestMapping("/books/new")
	    public String newBook(@ModelAttribute("book") BookModel book) {
	        return "/books/new.jsp";
	    }
	    @PostMapping(value="/books")
	    public String create(@Valid @ModelAttribute("book") BookModel book, BindingResult result) {
	        if (result.hasErrors()) {
	            return "/books/new.jsp";
	        } else {
	            bookService.createBook(book);
	            return "redirect:/books";
	        }
	    }
	    //MUESTRA INFO DE UN LIBRO ESPECIFICO
	    @GetMapping("/books/{id}")
		public String show(@PathVariable("id") Long id) {
			BookModel book = bookService.findBook(id);
			return "/books/show.jsp";
		}
}

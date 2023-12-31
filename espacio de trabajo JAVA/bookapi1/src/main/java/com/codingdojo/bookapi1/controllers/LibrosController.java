package com.codingdojo.bookapi1.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	    @GetMapping("/")
	    public String root() {
	    	return "redirect:/books";
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
	    @PostMapping("/books")
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
		public String show(@PathVariable("id") Long id, Model model) {
	    	 BookModel book = bookService.findBook(id);
		        model.addAttribute("book", book);
		        return "/books/show.jsp";
		}
	  //ELIMINA UN LIBRO ESPECIFICO
	    @DeleteMapping("/books/{id}")
		public String delete(@PathVariable("id") Long id) {
			bookService.deleteBook(id);
			return "redirect:/books";
		}
	    
		//EDITAR UN LIBRO
		@GetMapping("/books/{id}/edit")
	    public String edit(@PathVariable("id") Long id, Model model) {
	        BookModel book = bookService.findBook(id);
	        model.addAttribute("book", book);
	        return "/books/editbook.jsp";
	      
	    }
	    
	    @PutMapping("/books/{id}")
	    public String update(@Valid @ModelAttribute("book") BookModel book, BindingResult result) {
	        if (result.hasErrors()) {
	            return "/books/editbook.jsp";
	        } else {
	            bookService.updateBook(book);
	            return "redirect:/books";
	        }
	    }
	// ACTUALIZA LOS DATOS DE UN LIBRO ESPECIFICO
//		@PutMapping(value = "/books/{id}")
//		public BookModel updateBook(@PathVariable("id") Long id,
//				@RequestParam(value = "title") String title,
//				@RequestParam(value = "description") String desc,
//				@RequestParam(value = "language") String lang,
//				@RequestParam(value = "pages") Integer numOfPages) {
//			BookModel book = new BookModel(id, title, desc, lang, numOfPages);
//			return bookService.updateBook(book);
//}
}

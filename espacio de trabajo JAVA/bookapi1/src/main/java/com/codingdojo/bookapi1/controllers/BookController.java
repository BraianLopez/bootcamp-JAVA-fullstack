package com.codingdojo.bookapi1.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.codingdojo.bookapi1.models.BookModel;
import com.codingdojo.bookapi1.services.BookService;

@RestController
public class BookController {
	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping("/api/books")
	public List<BookModel> index() {
		return bookService.allBooks();
	}

	@PostMapping(value = "/api/books")
	public BookModel create(@RequestParam(value = "title") String title,
			@RequestParam(value = "description") String desc, @RequestParam(value = "language") String lang,
			@RequestParam(value = "pages") Integer numOfPages) {
		BookModel book = new BookModel(title, desc, lang, numOfPages);
		return bookService.createBook(book);
	}

	// LEE LOS DATOS DE UN LIBRO ESPECIFICO
	@GetMapping("/api/books/{id}")
	public BookModel show(@PathVariable("id") Long id) {
		BookModel book = bookService.findBook(id);
		return book;
	}

	// ACTUALIZA LOS DATOS DE UN LIBRO ESPECIFICO
	@PutMapping(value = "/api/books/{id}")
	public BookModel updateBook(@PathVariable("id") Long id, @RequestParam(value = "title") String title,
			@RequestParam(value = "description") String desc, @RequestParam(value = "language") String lang,
			@RequestParam(value = "pages") Integer numOfPages) {
		BookModel book = new BookModel(id, title, desc, lang, numOfPages);
		return bookService.updateBook(book);
	}
	//BORRA UN REGISTRO ESPECIFICO

	@DeleteMapping(value = "/api/books/{id}")
	public void delete(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
	}
}
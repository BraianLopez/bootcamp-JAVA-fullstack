package com.codingdojo.bookapi1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.bookapi1.models.BookModel;
import com.codingdojo.bookapi1.repositories.BookRepo;
@Service
public class BookService {
	//AGREGANDO EL BOOK AL REPOSITORIO COMO UNA DEPENDENCCIA
    private  BookRepo bookRepository;
    
    public BookService(BookRepo bookRepository) {
        this.bookRepository = bookRepository;
    }
    //DEVOLVIENDO TODOS LOS LIBROS 
    public List<BookModel> allBooks() {
        return bookRepository.findAll();
    }
    //CREANDO UN LIBRO.
    public BookModel createBook(BookModel book) {
        return bookRepository.save(book);
    }
    //OBTENIENDO INFORMACION DE UN LIBRO
    public BookModel findBook(Long id) {
        Optional<BookModel> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    //EDITANDO UN LIBRO.
    public BookModel updateBook(BookModel book) {
    	BookModel temporal = findBook(book.getId());
    	temporal.setTitle(book.getTitle());
    	temporal.setDescription(book.getDescription());
    	temporal.setNumberOfPages(book.getNumberOfPages());
    	temporal.setDescription(book.getDescription());
    	return bookRepository.save(temporal);
    }
    // SOBRECARGA DE METODO PARA EDITAR UN LIBRO
    public BookModel updateBook(Long id, 
    		String title, 
    		String desc, 
    		String lang, 
    		Integer numOfPages) {
    	BookModel temporal = bookRepository.findById(id).orElse(null);
    	if(temporal != null) {
    		temporal.setDescription(desc);
    		temporal.setLanguage(lang);
    		temporal.setNumberOfPages(numOfPages);
    		temporal.setTitle(title);
    		
    		bookRepository.save(temporal);
    		return temporal;
    	}else {
    		
    		return temporal;
    	}
    }
    //BORRANDO UN LIBRO
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
}

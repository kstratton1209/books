package com.keara.books.services;

import com.keara.books.repositories.BookRepository;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.keara.books.models.Book;

import java.util.List;

@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return (List<Book>) bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    public Book saveBook(Book b) {
        return bookRepository.save(b);
    }
   
    
    public void destroyBook(Long id) {
        bookRepository.deleteById(id);
    }
    
    public Book updateBook(Book toUpdate, Long id) { 
    	if(toUpdate.getId() == null) {
    		toUpdate.setId(id);
    	}
    	return bookRepository.save(toUpdate);
    }
    	
    	
    }
    
    
//    Book book = bookService.findBook(id);
//	book.setId(id);
//	book.setTitle(title);
//	book.setLanguage(lang);
//	book.setNumberOfPages(numOfPages);
//	
//	bookService.saveBook(book);
//	return book;
	


package com.keara.books.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.keara.books.models.Book;
import com.keara.books.services.BookService;

@Controller
public class BooksController {
	   private final BookService bookService;
	   
	   public BooksController(BookService bookService) {
	       this.bookService = bookService;
	   }
	    
	   @RequestMapping("/books")
	   public String index(Model model) {
		   model.addAttribute("books", bookService.allBooks());
		   model.addAttribute("book", new Book());

	       return "/books/index.jsp";
	    }
	   
	    @RequestMapping("/books/{id}/edit")
	    public String edit(@PathVariable("id") Long id, Model model) {
	        Book book = bookService.findBook(id);
	        model.addAttribute("book", book);
	        return "/books/edit.jsp";
	    }
	    
	    
	    @RequestMapping(value="/books/{id}/update", method=RequestMethod.PUT)
	    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result, @PathVariable("id") Long id) {
	    	if (result.hasErrors()) {
	    		System.out.println(result.getAllErrors());
	            return "/books/edit.jsp";
	        } else {
	            bookService.updateBook(book, id);
	            return "redirect:/books";
	        }

	    }
	    
	    @RequestMapping(value="/books/new")
	    public String newBook() {
		    return "/books/new.jsp";
	    }
	    
	    @RequestMapping(value="/create", method=RequestMethod.POST)
	    public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
	    	if (result.hasErrors()) {
	    		model.addAttribute("all",bookService.allBooks());
	            System.out.println(result.getAllErrors());
	        } else {
	        	bookService.createBook(book);
	        }
	    	return "redirect:/books";
	    	
	    }
	    
	    @RequestMapping(value="/books/{id}/show")
	    public String show(@PathVariable("id") Long id, Model model) {
	    	Book book = bookService.findBook(id);
	        model.addAttribute("book", book);
	    	return "/books/show.jsp";
	    }
	    
	    
	    @RequestMapping(value="/books/{id}/delete", method=RequestMethod.DELETE)
	    public String destroy(@PathVariable("id") Long id) {
	        bookService.destroyBook(id);
	    	return "/books/index.jsp";
	    }
	    

}
/*
 * created on May 23, 2021
 * 
 * $Author: jack98 $
 * $Revision: 1.0 $ 
 * $Date: May 23, 2021 $
 */
package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Book;
import com.example.demo.service.BookService;

@RestController
@RequestMapping("/api/v1")
public class BookApp {

    @Autowired
    private BookService bookService;
    
    @GetMapping("/books")
    public List<Book> getAll() { 
        return bookService.findAll();
    }
    
    @PostMapping("/books")
    public Book post(@RequestParam String name,
                     @RequestParam String author, 
                     @RequestParam String description,
                     @RequestParam int status) {
        
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setDescription(description);
        book.setStatus(status);
        
        bookService.save(book);
        
        return book;
    }
    
    @GetMapping("/books/{id}")
    public Book getOne(@PathVariable long id) {
        return bookService.findOne(id);
    }

    @PutMapping("/books")
    public Book update(@RequestParam long id,
            @RequestParam String name, 
            @RequestParam String author, 
            @RequestParam String description,
            @RequestParam int status) {
        
        Book book = new Book();
        book.setId(id);
        book.setName(name);
        book.setAuthor(author);
        book.setDescription(description);
        book.setStatus(status);
        
        bookService.save(book);
        
        return book;
    }
    
    @DeleteMapping("/books/{id}")
    public void deleteOne(@PathVariable long id) {
        bookService.deleteOne(id);
    }
}

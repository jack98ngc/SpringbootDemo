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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    public Page<Book> getAll(@RequestParam(defaultValue="0") int page, @RequestParam(defaultValue="5") int size) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return bookService.findAllByPage(new PageRequest(page, size, sort));
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
    
    @PostMapping("/books/by")
    public List<Book> findByAuthor(@RequestParam String author) {
        return bookService.findByAuthor(author);
    }

    @PostMapping("/books/by2")
    public List<Book> findByAuthorStatus(@RequestParam String author, @RequestParam int status) {
        return bookService.findByAuthorAndStatus(author, status);
    }

    @PostMapping("/books/by3")
    public List<Book> findByDescrptionEndsWith(@RequestParam String description) {
        return bookService.findByDescriptionEndsWith(description);
    }

    @PostMapping("/books/by4")
    public List<Book> findByDescrptionContains(@RequestParam String description) {
        return bookService.findByDescriptionContains(description);
    }

    @PostMapping("/books/by5")
    public List<Book> findByJPQL(@RequestParam int len) {
        return bookService.findByJPQL(len);
    }

    @PostMapping("/books/by6")
    public List<Book> findBySQL(@RequestParam int len) {
        return bookService.findBySQL(len);
    }

    @PostMapping("/books/by17-1")
    public int updateByJPQL(@RequestParam int status, @RequestParam long id) {
        return bookService.updateByJPQL(status, id);
    }

    @PostMapping("/books/by17-2")
    public int deleteByJPQL(@RequestParam long id) {
        return bookService.deleteByJPQL(id);
    }
    
    @PostMapping("/books/by18-1")
    public int deleteByJPQL(@RequestParam long id, @RequestParam int status, @RequestParam long uid) {
        return bookService.deleteAndUpdate(id, status, uid);
    }
    
    
}

/*
 * created on May 24, 2021
 * 
 * $Author: jack98 $
 * $Revision: 1.0 $ 
 * $Date: May 24, 2021 $
 */
package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.domain.Book;
import com.example.demo.service.BookService;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    
    @GetMapping("/books")
    public String list(@PageableDefault(size=5, sort= {"id"}, direction=Sort.Direction.DESC) Pageable pageable, 
            Model model) {
        Page<Book> page1 = bookService.findAllByPage(pageable);
        model.addAttribute("page", page1);
        return "books";
    }
    
    @GetMapping("/books/{id}")
    public String detail(@PathVariable long id, Model model) {
        Book book = bookService.findOne(id);
//        if(book == null) {
//            book = new Book();
//        }
        model.addAttribute("book", book);
        return "book";
    }
    
    @GetMapping("/books/input")
    public String inputPage(Model model) {
        model.addAttribute("book", new Book());
        return "input";
    }
    
    @GetMapping("/books/{id}/input")
    public String inputEditPage(@PathVariable long id, Model model) {
        Book book = bookService.findOne(id);
        model.addAttribute("book", book);
        return "input";
    }
    
    @PostMapping("/books")
    public String post(Book book, final RedirectAttributes attributes) {
        Book savedBook = bookService.save(book);
        if(savedBook !=null) {
            attributes.addFlashAttribute("message", String.format("???%s?????????????????????", savedBook.getName()));
        }
        return "redirect:/books";
    }
    
    /**
     * ??????Model.addAttribute?????????????????? 
     * 
     *          POST  --->  redirect  --->  GET
     *            ???                          ???
     *    model.addAttribute()          can't get message here
     * 
     */
}

/*
 * created on May 20, 2021
 * 
 * $Author: jack98 $
 * $Revision: 1.0 $ 
 * $Date: May 20, 2021 $
 */
package com.example.demo.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
@RequestMapping("/api/v1")
public class HelloControler {

    @RequestMapping("/say")
    public String say() {
        return "Hello Sprig Boot";
    }
    
    @GetMapping("/books")
//    @ResponseBody
    public Object getAll(@RequestParam("page") int page, @RequestParam(value="size", defaultValue="5") int size) {
        
        Map<String, Object> book = new HashMap<>();
        book.put("name","互聯網世界觀");
        book.put("isbn","9877234263432");
        book.put("author","李善友");
        Map<String, Object> book2 = new HashMap<>();
        book2.put("name","程序員的思維修煉");
        book2.put("isbn","1234261234261234");
        book2.put("author","李善友");
        
        List<Map> contents = new ArrayList<>();
        contents.add(book);
        contents.add(book2);
        
        Map<String, Object> pagemap = new HashMap<>();
        pagemap.put("page", page);
        pagemap.put("size", size);
        pagemap.put("contents", contents);
        
        return pagemap;
    }
    
    @Value("${book.name}")
    private String name;
    @Value("${book.author}")
    private String author;
    @Value("${book.isbn}")
    private String isbn;
    @Value("${book.description}")
    private String description;
    
    
    @GetMapping("/books/{id}")
    public Object getOne(@PathVariable long id) {
        
        Map<String, Object> book = new HashMap<>();
        book.put("name",name);
        book.put("isbn",isbn);
        book.put("author",author);
        book.put("description",description);
        return book;
    }
    
    @PostMapping("/books")
    public Object post(@RequestParam("name") String name,
                       @RequestParam("author") String author,
                       @RequestParam("isbn") String isbn){
        Map<String, Object> book = new HashMap<>();
        book.put("name",name);
        book.put("author",author);
        book.put("isbn",isbn);
        return book;
    }
                         
}

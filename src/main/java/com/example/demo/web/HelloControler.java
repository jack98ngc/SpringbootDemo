/*
 * created on May 20, 2021
 * 
 * $Author: jack98 $
 * $Revision: 1.0 $ 
 * $Date: May 20, 2021 $
 */
package com.example.demo.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public Object getAll() {
        
        Map<String, Object> map = new HashMap<>();
        map.put("name", "hello");
        map.put("age", "18");
        
        return map;
    }
    
    @GetMapping("/{id}/books/{username}")
    public Object getOne(@PathVariable long id, @PathVariable String username) {
        
        System.out.println(" --- id: " + id +" username: " + username);
        
        Map<String, Object> book = new HashMap<>();
        book.put("name","互聯網世界觀");
        book.put("isbn","9877234263432");
        book.put("author","李善友");
        book.put("username",username);
        return book;
    }
}

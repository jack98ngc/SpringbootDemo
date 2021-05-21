/*
 * created on May 20, 2021
 * 
 * $Author: jack98 $
 * $Revision: 1.0 $ 
 * $Date: May 20, 2021 $
 */
package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RestController
@RequestMapping("/api")
public class HelloControler {

    @RequestMapping("/say")
    public String say() {
        return "Hello Sprig Boot";
    }
    
    @GetMapping("/books")
    public String getAll() {
        return "books";
    }
}

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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RestController
@RequestMapping("/api")
public class HelloControler {

    @RequestMapping("/say")
    public String say() {
        return "Hello Sprig Boot";
    }
    
    @GetMapping("/books")
    @ResponseBody
    public Object getAll() {
        
        Map<String, Object> map = new HashMap<>();
        map.put("name", "hello");
        map.put("age", "18");
        
        return map;
    }
}

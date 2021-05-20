/*
 * created on May 20, 2021
 * 
 * $Author: jack98 $
 * $Revision: 1.0 $ 
 * $Date: May 20, 2021 $
 */
package com.example.demo.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {

    @RequestMapping("/say")
    public String say() {
        return "Hello Sprig Boot";
    }
    
    @RequestMapping(value="/sayWithMethod", method=RequestMethod.GET)
    /* NOTE: @RequestMapping(value="/sayWithMethod", method=RequestMethod.GET) equal to @GetMapping("sayWithMethod") */
    public String sayWithMethod() {
        return "Hello Sprig Boot with RequestMethod.GET";
    }

}

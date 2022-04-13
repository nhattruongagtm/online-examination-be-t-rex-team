package com.example.trex.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloTRex {

    @GetMapping("/hello")
    public String greeting(){
        return "Hello T-rex!";
    }
}

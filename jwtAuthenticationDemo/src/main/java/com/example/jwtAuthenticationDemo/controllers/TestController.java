package com.example.jwtAuthenticationDemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to Spring Security . This is not allowed for unauthenticated user !!";
    }
}

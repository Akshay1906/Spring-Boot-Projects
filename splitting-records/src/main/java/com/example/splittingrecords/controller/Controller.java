package com.example.splittingrecords.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @PostMapping("/insert")
    public String insert(){
        return null;
    }
}

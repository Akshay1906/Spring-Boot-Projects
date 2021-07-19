package com.example.Events.Controllers;

import com.example.Events.Entity.Student;
import com.example.Events.Services.AvailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyControllers {

    @Autowired
    AvailServices availServices;

    @GetMapping("/student")
    public List<Student> getData(){
        return this.availServices.getData();
    }

    @PostMapping("/create")
    public String createUser(){

        return this.availServices.createUser();
    }
}

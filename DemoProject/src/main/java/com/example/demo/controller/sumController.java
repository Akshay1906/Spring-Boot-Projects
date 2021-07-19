package com.example.demo.controller;

import com.example.demo.SumTwo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class sumController {
    @GetMapping("/sum")
    public String add(@RequestParam(value = "num1") int n1, @RequestParam(value = "num2") int n2){
        SumTwo obj= new SumTwo();
        obj.setNum1(n1);
        obj.setNum2(n2);
        return String.format("Sum = "+ (obj.getNum1() + obj.getNum2()));
    }
}

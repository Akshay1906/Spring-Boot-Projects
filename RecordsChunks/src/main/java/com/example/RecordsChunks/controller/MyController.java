package com.example.RecordsChunks.controller;

import com.example.RecordsChunks.model.Employee;
import com.example.RecordsChunks.service.ShowDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@RestController
public class MyController {

    @GetMapping("/getEmployee/pageSize/{pageSize}/&pageNo/{pageNo}")
    public List<Employee> getEmployee(@PathVariable String pageSize, @PathVariable  String pageNo) throws IOException {
        return ShowDetails.getEmployee(pageSize,pageNo);
    }
}

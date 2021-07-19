package com.example.Assignment5.controller;

import com.example.Assignment5.model.Request;
import com.example.Assignment5.model.Response;

import com.example.Assignment5.services.AvailableServices;
import com.example.Assignment5.services.ServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/reverse")
public class myControllers {

   @Autowired
   AvailableServices availableServices;

    @GetMapping("/orderOfWords")
    public ResponseEntity<?> reverseOrderOfWords(@RequestBody Request request){
        String result = this.availableServices.reverseOrderOfWords(request);
        ArrayList <Integer> pos = this.availableServices.palindromicPositions(result);
        return ResponseEntity.ok(new Response(request.getRequestString(),result,pos));
    }

    @GetMapping("/wordsWithInplaceReverse")
    public ResponseEntity reverseOrderWithInplace(@RequestBody Request request){
        String result = this.availableServices.reverseOrderWithInplace(request);
        ArrayList<Integer> pos = this.availableServices.palindromicPositions(result);
        return ResponseEntity.ok(new Response(request.getRequestString(),result,pos));
    }


}

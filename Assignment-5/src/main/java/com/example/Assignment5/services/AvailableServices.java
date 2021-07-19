package com.example.Assignment5.services;

import com.example.Assignment5.model.Request;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

import java.util.ArrayList;
@Component
public interface AvailableServices {

    public String reverseOrderOfWords(Request req);

    ArrayList<Integer> palindromicPositions(String result);

    String reverseOrderWithInplace(Request request);
}

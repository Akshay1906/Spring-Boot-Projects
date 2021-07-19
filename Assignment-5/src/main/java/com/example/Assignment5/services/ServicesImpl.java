package com.example.Assignment5.services;

import com.example.Assignment5.Logics.Palindrome;
import com.example.Assignment5.Logics.ReverseOrderOfWords;
import com.example.Assignment5.Logics.ReverseString;
import com.example.Assignment5.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicesImpl  implements  AvailableServices {
    @Autowired
    ReverseOrderOfWords reverseOrderOfWords;

    @Autowired
    Palindrome palindrome;

    @Autowired
    ReverseString reverseString;

    @Override
    public String reverseOrderOfWords(Request req) {
        String reversed = reverseOrderOfWords.applyLogic(req.getRequestString());
        return reversed;
    }

    @Override
    public ArrayList<Integer> palindromicPositions(String result) {
        ArrayList<Integer> pos = palindrome.applyLogic(result);
        return pos;
    }

    @Override
    public String reverseOrderWithInplace(Request request) {
        String reversed = reverseOrderOfWords.applyLogic(request.getRequestString());
        String[] words=reversed.split("\\s");
        String ans = "";
        for(int i = 0; i < words.length; i++){
                ans += ans.valueOf(reverseString.applyLogic(words[i]));
                ans += ans.valueOf(" ");
        }
        return ans;
    }
}

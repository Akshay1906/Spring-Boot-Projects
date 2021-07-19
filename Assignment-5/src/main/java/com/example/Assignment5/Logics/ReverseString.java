package com.example.Assignment5.Logics;

import org.springframework.stereotype.Component;

@Component
public class ReverseString {

    public String applyLogic(String str){

        String res = "";
        for(int i=str.length()-1;i>=0;i--)
        {
            res += res.valueOf(str.charAt(i));

        }
        return res;
    }


}

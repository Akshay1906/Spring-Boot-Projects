package com.example.Assignment5.Logics;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Palindrome {

    public Boolean checkWordForPalindrome(String word){
        int i = 0, j = word.length()-1;
        Boolean flag = false;

        while(i <= j){
            if(word.charAt(i) != word.charAt(j))
                return false;
            else{
                i++; j--;
            }

        }
        return true;
    }

    public ArrayList<Integer> applyLogic(String str){
        ArrayList<Integer> ans = new ArrayList<>();
        String[] words=str.split("\\s");
        for(int i = 0; i < words.length; i++){
            if(checkWordForPalindrome(words[i])){
                ans.add(i+1);
            }
        }
        return ans;
    }
}

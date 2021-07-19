package com.example.Assignment5.model;

import java.util.ArrayList;

public class Response {

    private String input;
    private String result;
    private ArrayList <Integer> palindromePos;

    public Response(){}

    public Response(String input, String result, ArrayList<Integer> palindromePos) {
        this.input = input;
        this.result = result;
        this.palindromePos = palindromePos;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public ArrayList<Integer> getPalindromePos() {
        return palindromePos;
    }

    public void setPalindromePos(ArrayList<Integer> palindromePos) {
        this.palindromePos = palindromePos;
    }
}

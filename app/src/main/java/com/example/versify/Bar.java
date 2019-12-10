package com.example.versify;

public class Bar {

    private String text;

    public Bar(String t) { text = t; }

    public String[] getWords() {
        String[] words = text.split(" ");
        return words;
    }
}

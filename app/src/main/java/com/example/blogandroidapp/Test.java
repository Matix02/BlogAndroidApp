package com.example.blogandroidapp;

public class Test {
    public static void main(String[] args) {
        String text = "This is text not inverted.";
        String invertedText = invert(text);
        System.out.println(String.format("Text: %s", text));
        System.out.println(String.format("Text inverted: %s", invertedText));
    }
    private static String invert(String text) {
        //TODO implement

        int lng = text.length();
        String fnText = "";
        for(int i = lng; i != 0; i--){
            char bf;
            bf = text.charAt(i);
            fnText += bf;

        }


        return fnText;
    }
}

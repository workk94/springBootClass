package com.acorn.day5.upload;

public class Test1 {
    public static void main(String[] args) {
        String str = "abc.png";

        int pos = str.lastIndexOf(".");
        String result = str.substring(pos + 1);
        System.out.println(result);
    }
}

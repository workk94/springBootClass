package com.acorn.ExceptionSample.예외처리;

import java.io.IOException;

public class Ex03 {
    public static void main(String[] args)  {


        int input  = 0;
        try {
            input = System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e); //  예외 발생 시 코드 흐름이 멈추게 할 수 있음 , 예외를 다시 일으킴
        }

        System.out.println( input);


    }
}

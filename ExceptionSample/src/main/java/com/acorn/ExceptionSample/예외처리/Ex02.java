package com.acorn.ExceptionSample.예외처리;

import java.io.IOException;

public class Ex02 {

    public static void main(String[] args) throws IOException {




        //예외미루기  방식으로 처리
        //간단하게 테스트하거나 예외처리를 할 필요가 없는경우에 사용할 수 있음


        int input  =  System.in.read();

        System.out.println( input);


    }
}

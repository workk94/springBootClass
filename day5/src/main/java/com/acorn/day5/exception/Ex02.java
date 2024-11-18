package com.acorn.day5.exception;

import java.io.IOException;

public class Ex02 {


    public static void main(String[] args){
        //입력용, 출력용 기반스트림을 제공함

        //System.in
        //System.out

        //in.read(); // 한바이트

        try {
            System.in.read();
        } catch (IOException e) {
            // 필수(checked) 예외를 처리하는 코드에서 다시 예외를 일으킬 때는
            // 선택 예외(RuntimeException 예외객체를 사용해서 예외를 발생시킴)
            System.out.println(e.getMessage());
            //throw new RuntimeException(e);
        }
    }
}

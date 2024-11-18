package com.acorn.ExceptionSample.예외처리;

import java.io.IOException;

import java.io.IOException;

public class Ex05 {

    public static void main(String[] args) {
        try {
            method1();
        } catch (Exception e) {
            System.out.println("method1 호출에서 오류발생" + e.getMessage());
        }
    }

    // method1에서 예외를 처리하고, 로그를 남긴 후 상위로 전파
    public static void method1() throws Exception {
        int result=0;
        try {
           result= doubler(-2);
        } catch (Exception e) {
            // 예외를 처리하면서 로그를 기록
            System.out.println("예외가 발생했을 때 해야할 일, 로그 남김 , 음수가 발생하였음");
            throw e; // 예외를 다시 일으킴 // 예외를 처리한 후, 상위 메서드로 전파
        }
        System.out.println("결과" + result);
    }

    // method2에서 예외를 발생시켜 상위 메서드로 전파

    public  static int  doubler( int su) throws Exception {
        if( su <=0   ){
            throw new Exception("0과  음수 안돼");
        }else{
            return su*2;
        }
    }
}



//예외가 발생하는 상황
//예와가 발생하지 않는 상황 확인하기
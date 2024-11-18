package com.acorn.ExceptionSample.예외처리;


public class Ex04 {
    public static void main(String[] args) {
        int result=0;
        try {
            result  =  doubler(0);
        } catch (Exception e) {
            throw new RuntimeException(e);  //예외를 다시 일으켜서 프로그램의 흐름을 종료함
        }


        System.out.println("프로그램 정상 종료" + result);

    }



    /*
      위의 코드에서  catch블럭에 throw new RuntimeException()이 존재하는 경우와 없는 경우에 대해서 생각해보자


       catch블럭에서 다시 예외를 일으키는 코드를 작성하는 이유
       1. 프로그램의 흐름을 멈추게 할 수 있디
       2. 상위로 예외를 전파할 수 있다

     */


    public  static int  doubler( int su) throws Exception {

        if( su <=0   ){
            throw new Exception("0과  음수 안돼");

        }else{
            return su*2;
        }
    }


}


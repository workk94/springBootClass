package com.acorn.day5.exception;

public class Ex01 {

    public static void main(String[] args) {

        // 런타임에러
        // Error(중대한 에러), Exception(미약한 에러)

        // 예외(Exception) : 미약한 에러
        // 종류 : 
        //Exception과 그 자손(필수처리 : checked)
        //RuntimeException과 그 자손(선택처리 : unchecked)

        // 예외를 처리한다는 것은?
        //예외가 발생되었을 때 해야할 대비코드를 작성하는 것
        //예외를 처리하게 되면 정상종료의 흐름을 갖는다
        // 예외를 처리하는 부분에서 필요하면 다시 예외를 일으키는 코드를 작성할 수 있다 

        // 방법
        //필수 : try-catch, throws (예외 미루기)
        //선택 : try-catch

        //1. 예외만들기

        int index = 4;
        try {

            int[] arr = new int[]{5,6,9}; // 0, 1, 2
            System.out.println(arr[index]);

            // 예외가 발생하면 이부분은 실행안됨
            System.out.println("배열의 요소 " + arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            // 예외가 발생하면 아래의 코드를 실행하세요
            //프로그램은 정상적인 흐름을 갖는다
            System.out.println(e.getMessage());

            //예외 다시 일으키기
            throw e;
        }

        // ArrayIndexOutOfBoundsException => RuntimeException의 자손이므로 예외처리가 필수가 아님
    }
}

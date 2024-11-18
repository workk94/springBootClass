package com.acorn.day5.exception;

public class Ex04 {

    public static void main(String[] args) {

        try {
            method();
        } catch (Exception e) {
            //throw new RuntimeException(e);
            System.out.println("method1 호출에서 오류 발생하였음");
            System.out.println("상위 메소드에서 해야할 코드 작성");
        }
    }

    // 여기서 doubler 호출
    public static void method() throws Exception {
        try {
            doubler(1000);
        } catch (Exception e) {
            System.out.println("예외가 발생했을때 해야할 코드 작성을 함, 로그남김, 음수발생하였음");

            // 예외 되전지기
            throw e ;
        }
    }

    public static int doubler(int su) throws Exception {
        if (su <= 0) {
            throw new Exception("0과  음수 안돼");
        } else {
            return su * 2;
        }
    }

}

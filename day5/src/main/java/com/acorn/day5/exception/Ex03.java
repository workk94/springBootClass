package com.acorn.day5.exception;

public class Ex03 {
    public static void main(String[] args) {

        int result = 0;
        try {
            doubler(-1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("프로그램 정상 종료 " + result);
    }


    //매서드 doubler
    //입력 : 숫자
    //반환 : 두배 숫자 반환
    public static int doubler (int n) throws Exception {
        if (n <= 0){
            throw new Exception("음수 안돼!!");
        }
        return n * 2;
    }
}

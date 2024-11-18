package com.acorn.ExceptionSample.예외처리;



//예외
/*
1.컴파일에러
2.논리적에러
3.런터임에러  (Error , Exception  : 미약한 에러)



Exception
  -Exception과 그 자손     (필수예외)
  -RuntimeExceptionr과 그 자손  (선택예외)


!!!
Exception을 상속받은 예외  ( 필수: checked )
RuntimeException을 상속받은 예외로 구분된다  ( 선택: unchecked)



  예외처리하는 방법 :

  선택예외  :  반드시  try~ catch
  필수예외  :  1) throws  예외 미루기   2)  try~catch





 */
public class Ex01 {


    public static void main(String[] args) {
        예외확인하기(1);
    }

    public static void 예외확인하기 (int i) {
        try {

            String str=null;
            switch (i) {
                //    예외가 발생하면 바로 실행을 멈추고 catch 문으로 감
                case 1: System.out.println("abc".charAt(3));break;
                case 2: System.out.println( str.length() ) ;break;
                case 3: System.out.println( "hello Exception");

            }


            //    아래의 코드는 예외가 발생하면 실행되지 않음
            System.out.printf("%d:   예외 없이 정상실행됨%n",  i);

        } catch (Exception e) {

            //   예외 발생시에만 실행되는 블록
            System.out.printf("예외 발생");
            System.out.println( e.getMessage() );
           // e.printStackTrace();
        }
    }


}

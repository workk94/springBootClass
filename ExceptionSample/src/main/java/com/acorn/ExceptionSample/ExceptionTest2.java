package com.acorn.ExceptionSample;


//예외 되던지기 
//예외의 일부처리하고 다시 예외 일으키기 

public class ExceptionTest2 {

	public static void main(String[] args) {
		 
		ExceptionTest2  e = new ExceptionTest2();
		try {
			e.method();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			System.out.println(" 나머지 부분 처리합니다");
		}
		 		
	}
	
	
	
	public void  method() throws Exception {		
		try {
		  throw new Exception();
		}catch( Exception e) {
			System.out.println("예외의 일부를 처리합니다");
			throw e;   // 예외 되던지기 
		}
	}

}

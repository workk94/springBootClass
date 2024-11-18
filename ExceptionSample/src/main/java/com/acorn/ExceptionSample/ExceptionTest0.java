package com.acorn.ExceptionSample;


 

public class ExceptionTest0 {

	public static void main(String[] args) {		 
		ExceptionTest0  e = new ExceptionTest0();		 
		e.method(); 
		 		
	}
	
	
	
	//예외가 발생되는 매서드
	public void  method()   {		
		try {
		  throw new Exception();  
		}catch( Exception e) {
			System.out.println("예외처리하기");			 
		}
	}

}

package com.acorn.ExceptionSample;

 

public class ExceptionTest1 {

	public static void main(String[] args) {		 
		ExceptionTest1  e = new ExceptionTest1();		 
		try {
			e.method();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		 		
	}
	
	
	//예와가 발생되는 매서드 		
	public void  method() throws Exception   {		
		 
		  throw new Exception();  
		  
	}

}

package com.example.uploadEx.요청응답;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class 폼데이터읽기GET_POST   {
	
	@GetMapping("/formRead")
    public String form(  )   {	
		return "formView";
	}

	
	@GetMapping("/formRead1")
     void test2(HttpServletRequest request ) throws ServletException, IOException {
      
		String id  = request.getParameter("id");
		String pw =  request.getParameter("pw");		
		
		System.out.println("Request header: 요청헤더에서 값 추출");
		System.out.println( id);
		System.out.println( pw);
		
		
    }
	
	

	@PostMapping("/formRead2")
     void test1(HttpServletRequest request ) throws ServletException, IOException {
		
		
		String id  = request.getParameter("id");
		String pw =  request.getParameter("pw");		
		
		System.out.println("Request header: 요청헤더에서 값 추출");
		System.out.println( id);
		System.out.println( pw);
		
		
		
		
		
		  int contentLength = request.getContentLength();
		  System.out.println( contentLength);
		  
	        if (contentLength > 0) {   
				
				try (BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"))) {
		                StringBuilder requestBody = new StringBuilder();
		                String line;		
		                while ((line = reader.readLine()) != null) {
		                    requestBody.append(line);
		                }		
		              
		                System.out.println("Request Body: 요청바디에서 값 추출");
		                System.out.println(requestBody.toString());
		            }
		   }  
	} 
	
	
	
    }






	 
 

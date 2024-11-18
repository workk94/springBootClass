package com.acorn.ExceptionSample;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice(basePackages = "com.acorn.ExceptionSample")
 //@ControllerAdvice
public class GlobalCatcher {
	
	@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
	@ExceptionHandler(Exception.class)
	public String catcher( Model model, Exception ex ) {		 			 
		  model.addAttribute("ex", ex);
		  return "err";
	}


}

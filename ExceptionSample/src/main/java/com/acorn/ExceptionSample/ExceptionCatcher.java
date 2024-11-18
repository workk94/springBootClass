package com.acorn.ExceptionSample;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
 

@Controller
public class ExceptionCatcher {
	
 
 	@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
	//@ExceptionHandler(Exception.class)
	public String catcher1( Model model, Exception ex ) {		 			 
		  model.addAttribute("ex", ex);
		  return "err";
	}
	 
	 
	// @ExceptionHandler(SQLException.class)
	public String catcher2( Model model, SQLException ex ) {
		  System.out.println("SqlException");	
		  model.addAttribute("ex", ex);
		  return "err";
	}
	
	
	 //@ExceptionHandler(MyException.class)
	public String catcher3(  Model model, MyException ex) {
		  System.out.println("");
		  model.addAttribute("ex", ex);
		  return "err";
	}
	 
	
	
	@RequestMapping(value = "/ex1", method = RequestMethod.GET)
	public void method1() throws Exception {
		throw new NullPointerException();
	}
	
	
	@RequestMapping(value = "/ex2", method = RequestMethod.GET)
	public void method2() throws SQLException {
		 throw  new   SQLException();
	}
	
	
	@RequestMapping(value = "/ex3", method = RequestMethod.GET)
	public void method3() throws MyException {		 
		 throw  new   MyException();
		 
	}
	
	

}

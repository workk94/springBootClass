package com.acorn.mapPrj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
public class json데이터모델로응답하기1 {
	

	
	@RequestMapping("/jsonMap")
	public String a( Model model) {
		
		  
		
		
		//Map을 사용하는 경우 , 별도의 클래스를 만들 필요없다
		
		Map<String, String> jsonMap = new HashMap<String, String>(); 
		jsonMap.put("title", "heldlo");
		jsonMap.put("la", "35.190165");
		jsonMap.put("lg", " 126.808852");
		
		
		 
		Map<String, String> jsonMap2 = new HashMap<String, String>();
		jsonMap2.put("title", "hello2");
		jsonMap2.put("la", "35.139558");
		jsonMap2.put("lg", "126.793159");
		
		ArrayList< Map<String, String>>  list = new ArrayList< Map<String, String>> ();
		list.add(jsonMap);
		list.add(jsonMap2);
		  

		 System.out.println( list);
		 model.addAttribute("item2", list);   // 자바객체로 모델로 넘김
		
		return  "jsonMap";
	}

}

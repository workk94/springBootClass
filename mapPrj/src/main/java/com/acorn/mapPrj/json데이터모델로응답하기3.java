package com.acorn.mapPrj;

import java.util.HashMap;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class json데이터모델로응답하기3 {

	
	
	@RequestMapping("/jsonModel")
	public void a( Model model) {
		
		
		//자바 객체를 사용하는 경우
		ItemDto item = new ItemDto();
		item.setId("test");
		item.setPw("0001");
		
		
		//Map을 사용하는 경우 , 별도의 클래스를 만들 필요없다
		Map<String, String> jsonMap = new HashMap<String, String>();
		jsonMap.put("one", "hello");
		jsonMap.put("two", "world");


		 model.addAttribute("item1", item);
		 model.addAttribute("item2", jsonMap);
		
		
	}

}

package com.acorn.mapPrj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class json데이터모델로응답하기2 {
	

	
	
	@RequestMapping("/jsonMap2")
	public void a( Model model) { 
		
		
		//Map을 사용하는 경우 , 별도의 클래스를 만들 필요없다
		 
		
		ArrayList<AreaCode> list = new ArrayList<>();
		list.add( new AreaCode("1001","강남구"));
		list.add( new AreaCode("1002","강서구"));
		list.add( new AreaCode("1003","노원구"));
		
		
		ArrayList<AreaCode> list2 = new ArrayList<>();
		list2.add( new AreaCode("2001","계양구"));
		list2.add( new AreaCode("2002","부천구"));
		list2.add( new AreaCode("2003","안양구"));
		 
		Map<String, ArrayList<AreaCode>> map = new HashMap< >();
		map.put("서울",  list);
		map.put("경기",  list2);
 
		 model.addAttribute("code", map);
		
		
	}

}

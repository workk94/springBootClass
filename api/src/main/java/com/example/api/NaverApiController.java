package com.example.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NaverApiController {




	@Autowired
	NaverApi4  naverApi;
	
	
	@ResponseBody
	@GetMapping(value="/naverList")
	public List<ItemDto> api( ){
		String response = naverApi.getAPIString();
		List<ItemDto> list = naverApi.fromJSONtoItems(response);
		return list;		
	}
	
	
	@ResponseBody
	@GetMapping(value="/naver"  , produces = "application/json;charset=utf-8")
	public String  api0( ){
		String response = naverApi.getAPIString();		 
		return response;		
	}
}

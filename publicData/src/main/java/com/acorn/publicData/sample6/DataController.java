package com.acorn.publicData.sample6;

import java.io.IOException;
import java.util.ArrayList;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DataController {
	
	@Autowired
	ApiExplorer2 api;

	
	
	
	
	    //1. 서버가 응답한 데이터 그대로  데이터로 응답하기

		@ResponseBody
		@RequestMapping(value = "/data", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
		public String test2() throws IOException {			 
			String result = "";		 
			result = api.getDatas();			 
			return result;
		} 
		
		
		//2. 서버가 응답한 데이터 가공하여 데이터로 응답하기
		@ResponseBody
		@RequestMapping(value = "/dataList", method = RequestMethod.GET)
		public ArrayList<DataDto> test3() throws IOException {
		 
			String   result = api.getDatas();
			ArrayList<DataDto>   list  =api.getDataList(result);			 
			return list;
		} 
		
		
		//3. 서버가 응답한 데이터 모델로 view로 응답하기
		@RequestMapping(value = "/dataview", method = RequestMethod.GET )
		public String test(HttpServletRequest request) throws IOException {
			 
			 		
			String result = api.getDatas();
			request.setAttribute("result", api.getDataList(result));			
			return "dataView";
		}

}

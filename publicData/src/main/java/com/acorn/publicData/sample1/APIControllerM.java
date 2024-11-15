package com.acorn.publicData.sample1;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class APIControllerM {

	@Autowired
	ApiExplorerM api;

	
	//문자열형태로 응답하기 때문에   produces 속성을 이용하여 json응답으로 수정해야 한다
	
	@ResponseBody
	@GetMapping(value = "/airM", produces = "application/json;charset=UTF-8")
	public String airApi() throws IOException {
		String result = api.getApiTest();
		return result;
	}
	
	
	//자바의 객체로 응답하면 기본 json으로 응답한다

	@ResponseBody
	@GetMapping(value = "/airListM")
	public ArrayList<AirDTO> airAPI() throws IOException {
		String result = api.getApiTest();
		ArrayList<AirDTO> list = api.fromJSONItems(result);
		return list;
	}


	// airCheckM  요청하면 view가 응답되고  응답된 view에서  서버의 데이터를 요청한다

	@RequestMapping(value = "/airCheckM", method = RequestMethod.GET)
	public void SearchAll2(Model model) throws SQLException, IOException {
	  
	}
}

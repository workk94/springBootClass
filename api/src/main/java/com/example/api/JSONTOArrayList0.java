package com.example.api;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONTOArrayList0 {

	public static void main(String[] args) {		
		
		JSONObject  jsonitem1  = new JSONObject();
		jsonitem1.put("id", "acor1");
		jsonitem1.put("pw", "0000");		
		JSONObject  jsonitem2  = new JSONObject();
		jsonitem2.put("id", "acorn2");
		jsonitem2.put("pw", "1234");
		JSONObject  jsonitem3  = new JSONObject();
		jsonitem3.put("id", "acorn3");
		jsonitem3.put("pw", "9999");
		
		
		JSONArray  arr = new JSONArray();
		arr.put(jsonitem1);
		arr.put(jsonitem2);
		arr.put(jsonitem3);
		
		System.out.println( arr);		
		// JSONArray  => ArrayList<UserDto>		
		ArrayList<UserDto> list = new ArrayList<>();

		for( int i=0; i< arr.length() ; i++) {
			JSONObject item = arr.getJSONObject(i);
			System.out.println(  item);
		    String id  = item.getString("id");
		    String pw =  item.getString("pw");		    
			UserDto user = new  UserDto( id, pw); 
			list.add(user);
		}
		
		//jsonArray  => arrayList 변환 
		System.out.println(  list); 
	}

}

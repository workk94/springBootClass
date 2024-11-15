package com.example.api;

 

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

 

 @Component
public class NaverApi4 {
 
    public static void main(String[] args) {
    	NaverApi4 naver = new NaverApi4();    	
        String responseBody  = naver.getAPIString();        
        System.out.println( responseBody); 
        
        //원하는 값 꺼내기 
       List<ItemDto> list  =  naver.fromJSONtoItems(responseBody);       
       System.out.println( list);
        
    }


	public   String getAPIString() {
		   String clientId = "QaMZOIzquZ2XCHAFDEMN"; //애플리케이션 클라이언트 아이디
		   String clientSecret = "GhQcIoHq8g"; //애플리케이션 클라이언트 시크릿 
		   
		    String text = null;
		    try {
		        text = URLEncoder.encode("bread", "UTF-8");
		    } catch (UnsupportedEncodingException e) {
		        throw new RuntimeException("검색어 인코딩 실패",e);
		    }


		    String apiURL = "https://openapi.naver.com/v1/search/shop?query=" + text;    // JSON 결과
		    //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // XML 결과


		    Map<String, String> requestHeaders = new HashMap<>();
		    requestHeaders.put("X-Naver-Client-Id", clientId);
		    requestHeaders.put("X-Naver-Client-Secret", clientSecret);
		    String responseBody = get(apiURL,requestHeaders);


		    System.out.println(responseBody);
		    
		    return responseBody;
	}


    private static String get(String apiUrl, Map<String, String> requestHeaders){
        HttpURLConnection con = connect(apiUrl);
        try {
            con.setRequestMethod("GET");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }


            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
                return readBody(con.getInputStream());
            } else { // 오류 발생
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }


    private static HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }

   
    
    private static String readBody(InputStream body){
        InputStreamReader streamReader = new InputStreamReader(body);

        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();


            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            } 
            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는 데 실패했습니다.", e);
        }
    }
    
 public ArrayList<ItemDto> fromJSONtoItems(String result){ 
      //응답데이터를  필요한 모델데이터로 만들기 
	  // 1. 응답데이터 중에서 관심있는 데이터 추출 
	  // 2. 자바객체로 만들기 ( ArrayList< ItemDto> )	   
	 
        JSONObject rjson  = new JSONObject(result);
        System.out.println( rjson);
        
        //주의사항  꺼내는 데이터의 값의 대상이  객체이면 getJSONObject(),  대상이 배열이면  getJSONArray() 사용해야 함   
        JSONArray items = rjson.getJSONArray("items");

        ArrayList<ItemDto> itemDtoList = new ArrayList<ItemDto>();
        for(int i=0; i <items.length(); i++){
            JSONObject itemJson =  items.getJSONObject(i);
            System.out.println( itemJson);
            /*String title = itemJson.getString("title");
            String image = itemJson.getString("image");
            String link =  itemJson.getString("link");
            int lprice = itemJson.getInt("lprice");*/
            ItemDto itemDto =  new ItemDto( itemJson);
            itemDtoList.add(itemDto);
        }
        return itemDtoList;

    }
    
}

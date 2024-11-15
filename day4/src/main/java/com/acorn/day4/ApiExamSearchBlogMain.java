package com.acorn.day4;


import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

@Component
public class ApiExamSearchBlogMain {

    public String getData() {
        String clientId = "QaMZOIzquZ2XCHAFDEMN"; //애플리케이션 클라이언트 아이디
        String clientSecret = "GhQcIoHq8g"; //애플리케이션 클라이언트 시크릿

        String text = null; // 검색어
        try {
            text = URLEncoder.encode("bread", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("검색어 인코딩 실패", e);
        }

        //요청 URL
        String apiURL = "https://openapi.naver.com/v1/search/shop?query=" + text;    // JSON 결과
        //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text;  

        HttpURLConnection con; //  네이버서버에 api요청시 사용
        StringBuilder body;    // 문자열연결시 사용

        //요청헤더   :  id, secret 추가 하는 코드   
        //요청바디   :

        try {
            URL url = new URL(apiURL);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
                InputStreamReader streamReader = new InputStreamReader(con.getInputStream());
                try (BufferedReader lineReader = new BufferedReader(streamReader)) {
                    body = new StringBuilder();
                    String line;
                    while ((line = lineReader.readLine()) != null) {
                        body.append(line);
                    }
                } catch (IOException e) {
                    throw new RuntimeException("API 응답을 읽는 데 실패했습니다.", e);
                }

            } else { // 오류 발생

                InputStreamReader streamReader = new InputStreamReader(con.getInputStream());
                try (BufferedReader lineReader = new BufferedReader(streamReader)) {
                    body = new StringBuilder();
                    String line;
                    while ((line = lineReader.readLine()) != null) {
                        body.append(line);
                    }
                } catch (IOException e) {
                    throw new RuntimeException("API 응답을 읽는 데 실패했습니다.", e);
                }
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiURL, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiURL, e);
        }

        System.out.println(body.toString());

        return body.toString();
    }

    // 매서드
    // 입력 : String(json구조를 가진 서버데이터 문자열)
    // 반환 : ArrayList<ItemDTO>

    public ArrayList<ProductDTO> fromJsonToItem(String result) {

        // 1. String -> JSONObject 변환
        // 2. 원하는 데이터까지 추출
        // 3. JSONArray -> ArrayList<ProductDTO>

        JSONObject obj = new JSONObject(result);
        System.out.println(obj);
        JSONArray items = obj.getJSONArray("items");

        //
        ArrayList<ProductDTO> list = new ArrayList<>();
        //반복

        for (int i = 0; i < items.length(); i++) {
            JSONObject itemjson = items.getJSONObject(i);
            System.out.println(itemjson);

            String title = itemjson.getString("title");
            String image = itemjson.getString("image");
            String link = itemjson.getString("link");
            String lprice = itemjson.getString("lprice");

            ProductDTO product = new ProductDTO(title, image, link, lprice);
            list.add(product);
        }

        return list;
    }

    public static void main(String[] args) {
        ApiExamSearchBlogMain api = new ApiExamSearchBlogMain();
        String result = api.getData();
        System.out.println(result);
    }

}

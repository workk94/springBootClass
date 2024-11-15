package com.acorn.publicData.test;


import com.acorn.publicData.sample6.DataDto;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;


@Component
public class ApiExplorer15 {
    public String getData() throws IOException {
      StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustFrcstDspth"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=E5K0ShAsEn6REfEqdHEQUWpQZ9F8RxQQLyrTHDmRibvbjSi2KEhW9vQcY3KNQHChKE0lSyL93L0VTZw7Rd6EUQ%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*xml 또는 json*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수(조회 날짜로 검색 시 사용 안함)*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호(조회 날짜로 검색 시 사용 안함)*/
        urlBuilder.append("&" + URLEncoder.encode("searchDate","UTF-8") + "=" + URLEncoder.encode("2024-11-14", "UTF-8")); /*통보시간 검색(조회 날짜 입력이 없을 경우 한달동안 예보통보 발령 날짜의 리스트 정보를 확인)*/
        urlBuilder.append("&" + URLEncoder.encode("InformCode","UTF-8") + "=" + URLEncoder.encode("PM10", "UTF-8")); /*통보코드검색(PM10, PM25, O3)*/
        URL url = new URL(urlBuilder.toString());


        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());


        return   sb.toString();
    }



    public static  void main( String[] args) throws IOException {

        ApiExplorer15  a = new  ApiExplorer15();
        String result  = a.getData();
        ArrayList<ItemDTO> list =a.fromJSONtoList( result);

        System.out.println( list);


    }





    public ArrayList<ItemDTO> fromJSONtoList(String result){



        ArrayList<ItemDTO> datas= new ArrayList< >();

        //String -> JSONObject 로 변환
        JSONObject obj= new JSONObject(result);

        JSONObject response= obj.getJSONObject("response");   // 키로  꺼내기
        JSONObject body= response.getJSONObject("body");      // 키로 꺼내기
        JSONArray items= body.getJSONArray("items");          // 키로  jsonarray 꺼내기
        System.out.println(items);

        for (int i = 0; i < items.length(); i++) {
            JSONObject item = items.getJSONObject(i);
            System.out.println("informGrade:" + item.getString("informGrade"));
            System.out.println("informCause.:" + item.getString("informCause"));
            System.out.println("dataTime.:" + item.getString("dataTime"));

            datas.add(new ItemDTO(item.getString("informGrade"), item.getString("informCause"), item.getString("dataTime")));
        }

        return datas;


    }



}
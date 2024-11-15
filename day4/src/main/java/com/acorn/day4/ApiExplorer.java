package com.acorn.day4;

/* Java 1.8 샘플 코드 */

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

@Component
public class ApiExplorer {

    public String getData() throws IOException {

        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustFrcstDspth"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=jg7DRY8%2FQYCfJypJWeES6h%2Fk2pDcZutjNKGCpiDumAk%2BibZD58I%2F8pX92QfMLshCZ%2FDTHbpiP%2B8kjgZjnQEIow%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("returnType", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*xml 또는 json*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수(조회 날짜로 검색 시 사용 안함)*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호(조회 날짜로 검색 시 사용 안함)*/
        urlBuilder.append("&" + URLEncoder.encode("searchDate", "UTF-8") + "=" + URLEncoder.encode("2024-11-14", "UTF-8")); /*통보시간 검색(조회 날짜 입력이 없을 경우 한달동안 예보통보 발령 날짜의 리스트 정보를 확인)*/
        urlBuilder.append("&" + URLEncoder.encode("InformCode", "UTF-8") + "=" + URLEncoder.encode("PM10", "UTF-8")); /*통보코드검색(PM10, PM25, O3)*/

        // URL 객체 생성
        URL url = new URL(urlBuilder.toString());

        // URL에서 URLConnection 객체 얻기
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
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
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        ApiExplorer a = new ApiExplorer();
        String result = a.getData();
        System.out.println("result " + result);

        /*//1. String(json 구조를 가진) => JSONObject 변환
        //2. 원하는 데이터 추출 items 꺼내면 날씨정보 여러개 (JSONArray) => ArrayList<DataDTO>

        JSONObject obj = new JSONObject(result);
        JSONObject response = obj.getJSONObject("response");
        System.out.println(response);

        JSONObject body = response.getJSONObject("body");
        System.out.println(body);

        JSONArray items = body.getJSONArray("items");

        // JSONArray => ArrayList<DataDTO>

        ArrayList<DataDTO> list = new ArrayList<>();

        for (int i = 0; i < items.length(); i++) {
            JSONObject itemjson = items.getJSONObject(i);
            //System.out.println(itemjson);
            //DataDTO변환
            String informGrade = itemjson.getString("informGrade");
            String dataTime = itemjson.getString("dataTime");
            String informCause = itemjson.getString("informCause");

            DataDTO itemData = new DataDTO(informGrade,dataTime,informCause);
            list.add(itemData);
            System.out.println(informGrade);
            System.out.println(dataTime);
            System.out.println(informCause);

            //변환 결과 출력
            System.out.println(list);
        }*/
    }

    public ArrayList<DataDTO> fromArrayToDataDTO(String result) { // String -> ArrayList<DataDTO>

        //1. String(json 구조를 가진) => JSONObject 변환
        //2. 원하는 데이터 추출 items 꺼내면 날씨정보 여러개 (JSONArray) => ArrayList<DataDTO>

        JSONObject obj = new JSONObject(result);
        JSONObject response = obj.getJSONObject("response");
        //System.out.println(response);

        JSONObject body = response.getJSONObject("body");
        //System.out.println(body);

        JSONArray items = body.getJSONArray("items");

        // JSONArray => ArrayList<DataDTO>

        ArrayList<DataDTO> list = new ArrayList<>();

        for (int i = 0; i < items.length(); i++) {
            JSONObject itemjson = items.getJSONObject(i);
            //System.out.println(itemjson);
            //DataDTO변환
            String informGrade = itemjson.getString("informGrade");
            String dataTime = itemjson.getString("dataTime");
            String informCause = itemjson.getString("informCause");

            DataDTO itemData = new DataDTO(informGrade, dataTime, informCause);
            list.add(itemData);
            //System.out.println(informGrade);
            //System.out.println(dataTime);
            //System.out.println(informCause);

            //변환 결과 출력
            //System.out.println(list);

        }
        System.out.println(list.size());
        return list;
    }
}
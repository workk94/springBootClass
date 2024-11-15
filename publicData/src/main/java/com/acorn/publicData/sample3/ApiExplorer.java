package com.acorn.publicData.sample3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.management.StringValueExp;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class ApiExplorer {
	public String getApiTest() throws IOException {
		StringBuilder urlBuilder = new StringBuilder(
				"http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustFrcstDspth"); /* URL */
		urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8")
				+ "=OfMyZxewfrwfKn%2B8xiFRjF52iKGgtKLlYHIgevGZHhnCpYaeE28H%2BUQqasQeHWdpW0Pzt38tkeI8toqYMIroUA%3D%3D"); /*
																														 * Service
																														 * Key
																													 */
		urlBuilder.append("&" + URLEncoder.encode("returnType", "UTF-8") + "="
				+ URLEncoder.encode("json", "UTF-8")); /* xml 또는 json */
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
				+ URLEncoder.encode("100", "UTF-8")); /* 한 페이지 결과 수(조회 날짜로 검색 시 사용 안함) */
		urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "="
				+ URLEncoder.encode("1", "UTF-8")); /* 페이지번호(조회 날짜로 검색 시 사용 안함) */
		urlBuilder.append("&" + URLEncoder.encode("searchDate", "UTF-8") + "="
				+ URLEncoder.encode("2024-11-14", "UTF-8")); /* 통보시간 검색(조회 날짜 입력이 없을 경우 한달동안 예보통보 발령 날짜의 리스트 정보를 확인) */
		urlBuilder.append("&" + URLEncoder.encode("InformCode", "UTF-8") + "="
				+ URLEncoder.encode("PM10", "UTF-8")); /* 통보코드검색(PM10, PM25, O3) */

		URL url = new URL(urlBuilder.toString());
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
		String result = sb.toString();
		return result;
	}

	public ArrayList<AirDTO> fromJSONItems(String result) {
		ArrayList<AirDTO> airList = new ArrayList<>();
		JSONObject jsonResult = new JSONObject(result);
		JSONObject response = jsonResult.getJSONObject("response");
		JSONObject body = response.getJSONObject("body");
		JSONArray items = body.getJSONArray("items");
		 

		for (int i = 0; i < items.length(); i++) {
			JSONObject item = items.getJSONObject(i);

			String informCause = item.getString("informCause");
			String dataTime = item.getString("dataTime");
			String informGrade = item.getString("informGrade");
			String image1 = String.valueOf(item.get("imageUrl4"));
			String image2 = String.valueOf(item.get("imageUrl5"));
			String image3 = String.valueOf(item.get("imageUrl6"));

			AirDTO airDTO = new AirDTO();
			airDTO.setInformCause(informCause);
			airDTO.setDataTime(dataTime);
			airDTO.setInformGrade(informGrade);
			airDTO.setImage1(image1);
			airDTO.setImage2(image2);
			airDTO.setImage3(image3);

			airList.add(airDTO);
		}

		return airList;
	}

}
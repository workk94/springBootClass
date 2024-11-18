package com.example.uploadEx.요청응답;


//클라이언트 화면에서 ajax, Fetch로 요청한다
//화면은 그대로 유지한채로 서버와 통신할 때 서버가 데이터를 응답한다



//@ResponseBody를 사용하면 반환값을 응답 본문(body)에 작성한다
// 이 때 JSON변환기가 사용됨 (JSON 라이브러리가 필요함!!)


import java.io.IOException;


import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class 서버가바로응답하기 {

	@GetMapping("/data1")
	public void test1(HttpServletResponse response) throws IOException {
		String message = "data1 서버가 보낸 데이터 message";
		response.setContentType("text/plain;charset=utf-8");
		response.setHeader("Content-Length", String.valueOf(message.getBytes().length));
		response.getWriter().println(message);

	}

	
	@GetMapping("/data2")
	public ResponseEntity<String> test2() {
		String message = " ResponseEntity 서버가 보내는 message !!!!";
		return ResponseEntity.ok().header("Content-Type", "text/plain;charset=utf-8")
				.header("Content-Length", String.valueOf(message.getBytes().length)).body(message);
	}
	
	
	
	 //produces 속성을 통해 명시적으로 MIME 타입을 지정할 때 사용함 
	@ResponseBody
	@RequestMapping( value="/data3"  , produces = "text/plain;charset=UTF-8" )
	public String test3() {
		String message = "서버가 보내는 message ^^^^^^";
		return message;
		 
	}
	
	// @ResponseBody를 사용하면   JSON 형식으로 응답
	 @ResponseBody
	 @GetMapping("/data4")
	  public  User  test4( )  {			 
		 User user = new User();
		 user.setId("gildong");
		 user.setPw("1234");
		 return user;		 
			
	 }
	 
	 
	 //JSON응답하기
	 @GetMapping("/data5")
	  public void test5(HttpServletResponse response ) throws IOException  {			
			response.setContentType("application/json;charset=utf-8"); 
			response.getWriter().println( "{ \"id\" : \"wjy\" , \"pw\":\"0000\"}");
			
	 }

	
	

}

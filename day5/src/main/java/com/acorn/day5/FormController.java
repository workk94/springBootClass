package com.acorn.day5;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

@Controller
public class FormController {

    //
    @GetMapping("/member")
    public String memberForm (){
        return "member";
    }

    @PostMapping("/member1")
    public String member1(HttpServletRequest req){

        String id = req.getParameter("id");
        String pw = req.getParameter("pw");
        String email = req.getParameter("email");

        System.out.println(id);
        System.out.println(pw);
        System.out.println(email);

        return "member";
    }

    @PostMapping("/member2")
    public String member2(HttpServletRequest req) throws IOException {

        // GET일때는 사용못함
        // 요청바디를 읽어올 수 있는 기반 스트림 제공
        // 보조 스트림을 사용함

        BufferedReader reader =  new BufferedReader(new InputStreamReader(req.getInputStream()));
        

        //새로운 문자열을 만드는 방법
        //String str = "hello";
        //str = str + "hi";

        // 수정이 가능한 문자열
        StringBuilder sb = new StringBuilder();
        String line = "";
        while((line=reader.readLine() )!= null){
            sb.append(line);
        }

        String requestBody = sb.toString();
        System.out.println(requestBody);

        String[] result = requestBody.split("&");

        //배열 출력
        Arrays.stream(result).forEach(item -> System.out.println(item)); // 람다식
        Stream.of(result).forEach(item -> System.out.println(item));
        Stream.of(result).forEach(System.out::println); // 매서드 참조
       return "member";
    }

    @PostMapping("/member3")
    public String member3(@ModelAttribute(name = "member")Member member){ // 커스텀 객체 바인딩과 모델에 전달까지 해줌

        System.out.println(member);
        return "member";
    }
}

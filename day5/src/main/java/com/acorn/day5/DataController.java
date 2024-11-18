package com.acorn.day5;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.Writer;

@Controller
public class DataController {

    @GetMapping("/data1")
    // 메서드의 머리부분 : 시그니처
    public void data1(HttpServletResponse resp) throws IOException {
        String message = "data1 서버가 보낸 데이터";

        //String.valueOf(5) => "5"
        resp.setContentType("text/plain;charset=utf-8");
        resp.setHeader("Content-Length",String.valueOf(message.getBytes().length));
        resp.getWriter().print(message);

    }

    //ResponseEntity 응답
    @GetMapping("/data2")
    public ResponseEntity<String> data2 () {

        String message = "data2 서버가 보내는 데이터!!!";
        ResponseEntity<String> data = ResponseEntity.ok()
                .header("Content-Type", "text/plain;charset=utf-8")
                .header("Content-Length", String.valueOf(message.getBytes().length))
                .body(message);


        return data;
    }

    @ResponseBody
    @GetMapping("/data3")
    public String data3(){
        String message = "data3 서버가 보내는 데이터";
        return message;
    }

    @ResponseBody
    @GetMapping("/data4")
    public Member data4 ( ){
        Member member = new Member();
        member.setId("acorn3");
        member.setPw("1234");
        member.setEmail("js@naver.com");
        return member;
    }

    @GetMapping("/data5")
    public void data5(HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().println("{\"id\": \"acorn01\", \"pw\": \"1234\", \"email\": \"hong@naver.com\"}");
    }
}

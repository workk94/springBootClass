package com.acorn.ExceptionSample;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/sample")
    public String sample1(Model model) {
        try {
            String result = method1();
            model.addAttribute("result", result);
            return "success"; // 정상적으로 처리된 경우 , 정상 view
        } catch (Exception e) {
             model.addAttribute("errorMessage", "오류발생 " + e.getMessage());
            return "errorView"; //  "error view "
        }
    }

    private String method1() throws Exception {
        // 예외를 강제로 발생시키는 예시
        throw new Exception("뭔가 잘못됨");
    }
}

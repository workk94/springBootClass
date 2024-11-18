package com.acorn.day5.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaskController2 {

    //
    @GetMapping("/sample1")
    public String sample1() {
        String result = "";

        try {
            errMethod();
            return "success";
        } catch (Exception e) {
            //throw new RuntimeException(e);
            return "errorView";
        }
    }

    @GetMapping("/sample2")
    public String sample2() {
        String result = "";

        try {
            errMethod();
            return "success";
        } catch (Exception e) {
            //throw new RuntimeException(e);
            return "errorView";
        }
    }



    private String errMethod() throws Exception {
        throw new Exception("에러 발생, 문제 있음");
    }
}

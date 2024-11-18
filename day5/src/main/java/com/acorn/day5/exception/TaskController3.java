package com.acorn.day5.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaskController3 {

    // @ExceptionHandler

    //해당 컨트롤러에서 발생하는 오류를 처리함
    //@ExceptionHandler(Exception.class)
    public String catcher () {
        return "err";
    }

    //
    @GetMapping("/sample3")
    public String sample1() throws Exception {
        errMethod();
        return "success";
    }

    @GetMapping("/sample4")
    public String sample2() throws Exception {
        errMethod();
        return "success";
    }

    private String errMethod() throws Exception {
        throw new Exception("에러 발생, 문제 있음");
    }
}

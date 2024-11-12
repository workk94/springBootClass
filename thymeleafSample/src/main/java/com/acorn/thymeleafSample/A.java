package com.acorn.thymeleafSample;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class A {

    @ResponseBody
    @GetMapping("/hitest")
    public  String a(){

        return  "dfdfd";
    }
}

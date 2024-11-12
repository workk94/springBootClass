package com.acorn.day1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Task1Controller {

    @Autowired
    Task1Service service;


    // 1. 두 수를 사용자로 부터 입력 받아 사칙연산해서 제공하기
    @GetMapping("/calc")
    public String test1(@RequestParam(name="su1", required = false, defaultValue = "1") int su1,
                        @RequestParam(name="su2", required = false, defaultValue = "1")  int su2, Model model) {

        // 서비스층
        // int result = su1 + su2;
        // System.out.println(result);
        int result = service.calc(su1, su2);

        model.addAttribute("result", result);

        return "task1view";
    }



}

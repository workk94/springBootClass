package com.acorn.day2API;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {

    //등록화면

    @GetMapping("/form")
    public String form() {
        return "formview";
    }

    //등록처리
    @PostMapping("/form")
    public String form2(Member member) {

        return "formview"; // 유효성 체크 후 다시 폼화면
        //return "formok"; // 정상적인 경우
    }
}

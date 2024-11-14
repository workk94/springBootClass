package com.acorn.day2API;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController2 {

    //화면
    @GetMapping("/form2")
    public String form(@ModelAttribute Member member) {
        /*
    요청 파라미터가 없으면, Spring이 Member 객체의 빈 인스턴스를 생성하여 member에 바인딩 함
    @ModelAttribute는 모델에 데이터를 추가하는 역할도 하기 때문에, 별도의 작업 없이 member가 모델에 저장됨

     */
        return "formview2";
    }

    @PostMapping("/form2")
    public String form2(@ModelAttribute Member member) {

        System.out.println(member);

        return "formview2";
    }
}

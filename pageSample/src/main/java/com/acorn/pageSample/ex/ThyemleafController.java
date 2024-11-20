package com.acorn.pageSample.ex;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class ThyemleafController {



    //특정범위 반복하기
    @GetMapping("/thyme1")
    public String  method1(  Model model){
        return  "thymeleafView";
    }


    //조건에 맞는것 출력하기
    @GetMapping("/thyme2")
    public String  method2(  Model model){


        int su=10;
        model.addAttribute("su", su); // 모델에 숫자 추가


        return  "thymeleafView2";

    }



    //조건에 맞는것 출력하기
    @GetMapping("/thyme3")
    public String  method3(  Model model){


        int su=5;
        model.addAttribute("su", su); // 모델에 숫자 추가


        return  "thymeleafView3";

    }



    @GetMapping("/thyme4")
    public String method4(Model model){
        List<Acorn> acorns = new ArrayList<>();

        acorns.add(new Acorn("acorn1", "pw1", "acorn1@naver.com"));
        acorns.add(new Acorn("acorn2", "pw2", "acorn2@google.com"));
        acorns.add(new Acorn("acorn3", "pw3", "acorn3@daum.com"));
        acorns.add(new Acorn("acorn4", "pw4", "acorn4@naver.com"));
        acorns.add(new Acorn("acorn5", "pw5", "acorn5@google.com"));

        model.addAttribute("list", acorns);

        return  "thymeleafView4";
    }

}

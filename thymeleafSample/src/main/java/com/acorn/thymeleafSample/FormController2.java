package com.acorn.thymeleafSample;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController2 {

    @GetMapping("/form2")
    public String form(  ){

        return "thymeleaf/form2";
    }



    @PostMapping("/form2")
    public String form2( Member member){


        System.out.println(  member);

         return "thymeleaf/form2";


    }


}

package com.example.thyeleafLayout;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Hello {


    @GetMapping("/hi")
    public  String hi(){

        return "index";
    }



    @GetMapping("/hi2")
    public  String hi2(){

        return "hi";
    }



    @GetMapping("/hi3")
    public  String hi3(){

        return "layoutView";
    }
}

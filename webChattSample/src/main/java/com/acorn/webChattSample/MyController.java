package com.acorn.webChattSample;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {


    @GetMapping("/chatt")
    public String viewname(){
        return "chatt";
    }


}

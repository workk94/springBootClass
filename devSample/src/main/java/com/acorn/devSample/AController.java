package com.acorn.devSample;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AController {


    @ResponseBody
    @GetMapping("/test1")
    public String a(){

        return "^____^ Data8888777 ";
    }


    @GetMapping("/test2")
    public String b(){

        return "testview";
    }

}

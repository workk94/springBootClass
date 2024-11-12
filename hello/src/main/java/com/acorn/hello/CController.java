package com.acorn.hello;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CController {



    @GetMapping("/cute")
    public String  cute(){


        return "cuteview";
    }
}

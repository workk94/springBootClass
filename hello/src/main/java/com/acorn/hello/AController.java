package com.acorn.hello;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
public class AController {


    @ResponseBody
    @GetMapping("/hi")
    public String hi(){


        return  "hi  data ^_____________________________!!^";
    }




    @GetMapping("/hi2")
    public String hi2( Model model){

        model.addAttribute("userid" ,"acorn");
        model.addAttribute("hobby" , "walk");

        List<String> list  = new ArrayList<>();
        list.add("아메리카노");
        list.add("카푸치노");
        list.add("달고나커피");

        model.addAttribute("list", list);

        return  "hi";
    }
}

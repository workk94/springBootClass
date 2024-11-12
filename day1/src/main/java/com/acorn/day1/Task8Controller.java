package com.acorn.day1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Task8Controller {

    @Autowired
    Task8Service service;

    @GetMapping("/randommsg")
    public String task8(Model model){

        //모델 심기
        String result = service.getRandmomMsg();
        model.addAttribute("randomMessage",result);
        return "task8view";
    }

}

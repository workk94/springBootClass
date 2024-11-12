package com.acorn.day1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Task5Controller {

    @RequestMapping(value = "/star", method = RequestMethod.GET)
    public String task5(@RequestParam(name = "cnt", defaultValue = "1", required = false)Integer cnt, Model model){
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= cnt; i++) sb.append("*");
        model.addAttribute("result", sb.toString());
        return "task5view";
    }
}

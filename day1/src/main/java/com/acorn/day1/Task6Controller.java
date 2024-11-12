package com.acorn.day1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class Task6Controller {

    @GetMapping("/divisor")
    public String task6(@RequestParam(name = "num", defaultValue = "1", required = false)Integer num, Model model) {

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 1; i <= num; i++){
            if(num % i == 0) list.add(i);
        }
        model.addAttribute("list", list);
        return "task6view";
    }

}

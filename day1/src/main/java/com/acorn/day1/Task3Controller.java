package com.acorn.day1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Controller
public class Task3Controller {

    @GetMapping("/dan")
    public String task3(@RequestParam(name = "num", defaultValue = "2", required = false) int num, Model model){

        List<String> list = new ArrayList<>();

        for(int i = 1; i <= 9; i++){
            list.add(num + " * "+ i + " = " + num * i);
        }

        model.addAttribute("list", list);

        return "task3view";
    }
}

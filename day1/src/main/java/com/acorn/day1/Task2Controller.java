package com.acorn.day1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class Task2Controller {

    @Autowired
    Task2Service service;

    @RequestMapping(value = "/dan3", method = RequestMethod.GET)
    public String task2(Model model){
        List<String> list = service.getdan3();
        model.addAttribute("list", list);

        return "task2view";
    }

}

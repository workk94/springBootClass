package com.acorn.day4;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class NaverController {

    @Autowired
    ApiExamSearchBlogMain api;

    @ResponseBody
    @GetMapping(value ="naverdata", produces = "application/json;charset=utf-8")
    public String naverdata() {
        String result = api.getData();
        return result;
    }

    @GetMapping("/naverlist")
    public String mvc(Model model) {
        String result = api.getData();
        ArrayList<ProductDTO> list =  api.fromJsonToItem(result);
        model.addAttribute("list", list);
        return "naverView";
    }


    @ResponseBody
    @GetMapping("/naverdata2")
    public ArrayList<ProductDTO> data() {
        String result = api.getData();
        ArrayList<ProductDTO> list =  api.fromJsonToItem(result);
        return list;
    }
}

package com.acorn.day4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;

@Controller
public class ApiController {

    @Autowired
    ApiExplorer api;



    @ResponseBody
    @GetMapping( value="/data"   , produces = "application/json;charset=utf-8"  )
    public String  getdata() throws IOException {
        String  reuslt  = api.getData();
        return  reuslt;
    }


    //
    @GetMapping("/dataList")
    public String mvc(Model model) throws IOException {
        String  result  = api.getData();
        ArrayList<DataDTO> list =  api.fromArrayToDataDTO(result);

        System.out.println(list);

        model.addAttribute("list", list);

        return "dataView";
    }
}
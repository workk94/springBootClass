package com.acorn.publicData.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class fdkdfk {



    @GetMapping("/aa")
    public  String a( Model model){

        List<ItemDTO> a= new ArrayList<>();
        a.add( new ItemDTO("dfd","dfd","dfdf"));


        model.addAttribute("aa" , a);



        return "aa"
;    }
}

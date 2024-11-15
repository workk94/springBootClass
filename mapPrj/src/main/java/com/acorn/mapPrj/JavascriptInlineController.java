package com.acorn.mapPrj;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JavascriptInlineController {


    @GetMapping("/javascriptInline")
    public  String   thyemleatJavascriptInline( Model model){


        //자바 객체를 사용하는 경우
        ItemDto item = new ItemDto();
        item.setId("test");
        item.setPw("0001");


        model.addAttribute("item" , item);

        return   "javascriptInlineView";

    }

}

package com.acorn.day5.upload;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LinkTest {

    @GetMapping("/testview")
    public String view(Model model) {

        model.addAttribute("data1", "data1임");
        model.addAttribute("data2", "data2임");
        model.addAttribute("data3", "data3임");
        model.addAttribute("data4", "data4임ㅋㅋ");
        return "upload/testview";
    }


    @GetMapping("/a")
    public void test1(@RequestParam(name = "dat1", required = false, defaultValue = "") String data1){
        System.out.println(data1);
    }

    @GetMapping("/b")
    public void test2(@RequestParam(name = "dat1", required = false, defaultValue = "") String data2,
                      @RequestParam(name = "dat1", required = false, defaultValue = "") String data3){
        System.out.println(data2);
        System.out.println(data3);
    }


    @GetMapping("/c/{data4}")
    public void test3(@PathVariable(name = "data4") String data4){
        System.out.println(data4);
    }
}

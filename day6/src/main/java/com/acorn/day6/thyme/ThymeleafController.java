package com.acorn.day6.thyme;

import com.acorn.day6.PageHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class ThymeleafController {

    @GetMapping("/thyme1")
    public String method1(Model model) {

        model.addAttribute("start", 11);
        model.addAttribute("end", 20);

        return "thyme1View";
    }

    @GetMapping("/thyme2")
    public String method2(Model model) {

        ArrayList<Acorn> list = new ArrayList<>();
        model.addAttribute("list", list);
        model.addAttribute("num", 10);
        return "thyme2View";
    }

    @GetMapping("/thyme3")
    public String method3(Model model){
        ArrayList<Acorn> list = new ArrayList<>();
        list.add(new Acorn("acorn1", "1234", "kim"));
        list.add(new Acorn("acorn2", "0000", "lee"));
        list.add(new Acorn("acorn3", "2412", "park"));

        model.addAttribute("list", list);
        return "thyme3View";
    }


    @GetMapping("/thyme4")
    public String method4(Model model){

        model.addAttribute("su", 10);
        return "thyme4View";
    }

    @GetMapping("/thyme5")
    public String method5(Model model){
        PageHandler handler = new PageHandler(1,10,100,5);
        model.addAttribute("pageHandler", handler);
        return "thyme5View";
    }


    @GetMapping("/thyme6")
    public String method6(Model model) {
        model.addAttribute("itemName", "딸기");
        model.addAttribute("itemValue", "1");
        return "thyme6View";
    }

    //엘비스 연산자, no Operation 연습
    @GetMapping("/thyme7")
    public String method7(Model model){
        model.addAttribute("data", "hello data");
        model.addAttribute("data2", null);
        return "thyme7View";
    }
}

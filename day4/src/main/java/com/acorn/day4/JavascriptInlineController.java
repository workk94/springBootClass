package com.acorn.day4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JavascriptInlineController {

    @GetMapping("/javascript")
    public String method(Model model) {

        Member member = new Member();
        member.setId("acorn1");
        member.setPw("1234");

        model.addAttribute("user", member);
        return "javascriptInline";
    }
}

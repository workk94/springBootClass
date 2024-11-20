package com.acorn.day7.Intercepter;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {

    //
    @GetMapping("/acornOrder")
    public String order() {
        //세션
        return "orderlist";
    }

    @GetMapping("/acornLogin")
    public String login() {
        return "acornLogin";
    }

    @PostMapping("/acornLogin")
    public String login2 (@RequestParam(name = "id", required = false) String id,
                          @RequestParam(name="pw", required = false) String pw, HttpSession session){

        // 세션에 저장
        session.setAttribute("ACORNID", id);
        return "redirect:/acornHome";
    }

    @GetMapping("/acornLogout")
    public String acornLogout(HttpSession session) {
        session.invalidate();
        return "redirect:/acornHome";
    }

    @GetMapping("/acornHome")
    public String home (){
        return "acornHome";
    }
}

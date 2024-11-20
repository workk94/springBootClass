package com.acorn.day7.session;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class OrderController {

    @GetMapping("/order")
    public String order (HttpServletRequest request) {
        //세션을 체크하는 로직
        HttpSession session =  request.getSession(false); // 세션이 없으면 null, 세션이 있으면 기존의 세션을

        if (session == null || session.getAttribute("SESSIONID") == null){
            // 로그인하지 않음
            return "redirect:/login";
        }

        return "order";
    }
    @GetMapping("/board")
    public String board (@SessionAttribute(name="SESSIONID", required = false) String SESSIONID) {
        //세션을 체크하는 로직

        if (SESSIONID == null){
            //로그인 화면으로 재요청
            return "redirect:/login";
        }
        return "board";
    }
}

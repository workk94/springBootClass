package com.acorn.day7.session;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String loginForm(@CookieValue(value = "id", required = false, defaultValue = "") String id, Model model) {
        model.addAttribute("id", id);
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam(name = "id", required = false) String id,
                        @RequestParam(name = "pw", required = false) String pw,
                        @RequestParam(name = "rmid", required = false) boolean rmid,
                        HttpServletRequest request,
                        HttpServletResponse resp) {

        System.out.println(id);
        System.out.println(pw);
        System.out.println(rmid);
        //check

        //사용자 인증
        //세션에 저장
        HttpSession session = request.getSession(); // request.getSession(true);
        // true : 세션이 없으면 새로운 새션을 생성
        // 세션이 있으면 기존의 세션을 반환
        session.setAttribute("SESSIONID", id);

        //아이디 기억 쿠키
        if (rmid){ // 아이디기억 o
            //쿠키생성
            Cookie cookie = new Cookie("id" ,id);
            cookie.setMaxAge(60*60); // 1시간
            resp.addCookie(cookie);
        } else {
            // 아이디 기억 x
            Cookie cookie = new Cookie("id", id);
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
        }

        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        // 세션이 없으면 null을 반환함
        // 세션이 있으면 세션을 반환
        if(session != null){
            session.invalidate();
            //session.removeAttribute("SESSIONID");
        }

        return "redirect:/home";
    }

}

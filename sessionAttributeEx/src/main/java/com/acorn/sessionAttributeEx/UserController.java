package com.acorn.sessionAttributeEx;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
@Controller
@RequestMapping("/user")
@SessionAttributes("sessionId")  //sessionId라는 이름으로 모델에 저장된 것만 세션에 자동 저장됨
public class UserController {

    // 로그인 페이지
    @GetMapping("/login")
    public String loginPage() {
        return "login"; // 로그인 폼을 보여주는 JSP로 이동
    }

    // 로그인 처리
    @PostMapping("/doLogin")
    public String doLogin(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          Model model) {
        // 간단히 사용자 인증 성공으로 처리
        if ("user".equals(username) && "pass".equals(password)) {
            // 모델에 사용자 정보 저장 (세션에도 저장됨)
            model.addAttribute("sessionId", username);
            return "redirect:/user/home"; // 로그인 후 홈으로 리다이렉트
        }
        return "redirect:/user/login?error=true"; // 로그인 실패 시 다시 로그인 페이지로
    }

    // 사용자 홈
    @GetMapping("/home")
    public String home(@SessionAttribute(name = "sessionId", required = false) String sessionId) {
        // 세션에서 값 가져오기
        if (sessionId == null) {
            return "redirect:/user/login"; // 세션에 값이 없으면 로그인 페이지로 리다이렉트
        }
        return "home"; // 로그인한 사용자가 있으면 home 페이지로 이동
    }

    // 로그아웃 처리
    @RequestMapping("/logout")
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete(); // 세션 데이터 제거
        return "redirect:/user/login"; // 로그아웃 후 로그인 페이지로 리다이렉트
    }
}


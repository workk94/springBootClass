package com.acorn.day7.cookie;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/main")
    public String main(@CookieValue(name = "userAge", required = false) String userAge , HttpServletResponse response) {

        //1.userAge 쿠키 여부 check
        //2. 쿠키 없는 경우
        if(userAge == null){
            // 로그인한 사용자면 사용자의 나이정보를 가져온다
            userAge = "30";
            // 키  : 값 // 문자열만 가능함
            Cookie cookie = new Cookie("userAge", userAge);
            cookie.setPath("/");
            response.addCookie(cookie);
        }


        //3. 쿠키 있는 경우

        int ageInt = Integer.parseInt(userAge);

        //사용자 나이에 대한 뷰 반환
        if (ageInt >= 20 && ageInt < 30) {
            return "view20";
        } else if (ageInt >= 30 && ageInt < 40) {
            return  "view30";
        } else {
            return "main";
        }

    }
}

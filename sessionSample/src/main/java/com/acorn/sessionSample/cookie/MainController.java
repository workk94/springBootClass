package com.acorn.sessionSample.cookie;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/main")
    public String main(HttpServletRequest request , HttpServletResponse response){


        // 쿠키에서 "age" 값을 가져오기
        Cookie[] cookies = request.getCookies();
        String age = null;

        if (cookies != null) {   // 널체크 해야 함 !!

            for (Cookie cookie : cookies) {
                if ("age".equals(cookie.getName())) {
                    age = cookie.getValue(); // age 쿠키 값을 가져옴
                    break;
                }
            }
        }

        if (age == null) {
            // age 쿠키가 없다면 쿠키를 생성하고 "main" view를 반환
            age = "40"; //   로그인한 사용자라면  데이터베이스로부터 가져옴
            Cookie ageCookie = new Cookie("age", age);
            ageCookie.setMaxAge(60 * 60 * 24 * 365); // 쿠키의 유효 기간을 1년으로 설정
            //  ageCookie.setPath("/admin"); ///admin과 그 하위에서만 쿠키 전달
             ageCookie.setPath("/"); // 모든 경로에서 접근 가능하도록 설정
            response.addCookie(ageCookie); // 쿠키 응답에 추가
            return "main"; // 기본 화면 반환
        }

        // age 쿠키가 있으면 해당 나이에 맞는 view 반환
        int ageInt = Integer.parseInt(age); // 쿠키 값은 String 형태이므로 int로 변환

        if (ageInt >= 20 && ageInt < 30) {
            return "view20"; //  20대를 위한 뷰
        } else if (ageInt >= 40 && ageInt < 50) {
            return "view40"; //  40대를 위한 뷰
        } else {
            return "main"; //
        }
    }

}

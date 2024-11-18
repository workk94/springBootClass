package com.acorn.day5.exception;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 컨트롤러보다 더 넓은 범위의 에러 잡기
// 전역으로 사용됨
@ControllerAdvice(basePackages = "com.acorn.day5.exception")
// basePackages 로 com.acorn.day5.exception에서 발생하는 오류만 잡을 수 있다
public class GlobalCatcher {
    @ExceptionHandler(Exception.class)
    public String catcher1 (Model model, Exception ex) {
        model.addAttribute("ex", ex);
        return "err";
    }

}

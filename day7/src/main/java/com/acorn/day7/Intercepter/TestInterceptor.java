package com.acorn.day7.Intercepter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TestInterceptor implements HandlerInterceptor {

    //controller 호출되기 전에 실행
    // return true; => 호출된 정상흐름으로 넘어감
    // return false; => 멈춤
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //요청전의 생성한 값을 요청 후에 쓰고 싶으면 => request 저장소 사용함
        String data = "hi interceptor";
        request.setAttribute("data", data);
        request.setAttribute("start", System.currentTimeMillis());

        // HandlerInterceptor.super.preHandle(request, response, handler);
        System.out.println("hi");
        return true;
    }

    //Controller가 정상수행 되고 나서 호출됨
    //Controller에서 예외가 발생하면 호출되지 않는다!!!
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
        System.out.println("postHandle");
        System.out.println(modelAndView.getView());
        System.out.println(modelAndView.getModel());
    }

    //응답후 호출됨
    //예외랑 상관없이 무조건 호출됨
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
        System.out.println("bye");

        String data = (String) request.getAttribute("data");
        System.out.println(data);

        Long  start = (Long) request.getAttribute("start"); // 처음시간
        long end  = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
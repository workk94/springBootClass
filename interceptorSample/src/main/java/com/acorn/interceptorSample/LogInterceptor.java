package com.acorn.interceptorSample;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;


public class LogInterceptor implements HandlerInterceptor {

	// 요청 전 처리
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String requestURI = request.getRequestURI();
		String method = request.getMethod();


		System.out.println( "preHandle==");
		System.out.println( "컨트롤러 요청 되기 전에 호출됨");
		System.out.println("URI: " + requestURI);
		System.out.println("Method: " + method);


		// 요청 정보를 속성으로 저장 (afterCompletion에서 사용 가능)
		// request 저장소를 사용함
		request.setAttribute("start", System.currentTimeMillis());
		return true;
	}

	// 요청 처리 후 (뷰 렌더링 전)
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		System.out.println("==== 요청 응답이후 , 예외가 발생하면 호출되지않음====");
		System.out.println("Handler: " + handler);

		if (modelAndView != null) {
			System.out.println("View Name: " + modelAndView.getViewName());
			System.out.println("Model Data: " + modelAndView.getModel());
		}

	}

	// 응답완료 후 호출됨 (뷰 렌더링 후 또는 예외 발생 후)
	//
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		Long start = (Long) request.getAttribute("start");
		long 걸린시간 = System.currentTimeMillis() - start;

		System.out.println("==== afterCompletion ====");
		System.out.println("Time Taken: " + 걸린시간 + "ms");


		if (ex != null) {
			System.out.println("Exception: " + ex.getMessage());
		}

	}
}

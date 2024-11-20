package com.acorn.interceptorSample;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;



//return 값이  true => 원래요청 흐름으로 진행
//return 값이  false =>원래요청 흐름이 중지됨
public class SessionInterceptor implements HandlerInterceptor {

	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {


		System.out.println("sessionInterceptor");
		//요청 정보를 확인할 수 있다.
		String requestURI = request.getRequestURI();
		System.out.println(requestURI);

		HttpSession session = request.getSession(false);
		//HttpSession session = request.getSession(false); 의미:  세션이 있으면 가져오고 없으면  null반환
		//HttpSession session = request.getSession();  //세션이 없으면 새로운 세션을 생성함

		if (session == null || session.getAttribute("loginID") == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return false;
		}

// 로그인된 사용자에 대한 처리 로직 (예: 로그인 ID 출력 등)
		String loginID = (String) session.getAttribute("loginID");
		System.out.println("인터셉터 로그인여부: " + loginID);

		return true;  // 원래요청의 controller가 요청됨

	}
    
}

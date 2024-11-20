package com.acorn.sessionSample;

import java.net.URLEncoder;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {
	 
	
	 @RequestMapping("/login")
	 // public String loginForm(@CookieValue(value = "id" ,required = false) String id, Model model) {
	 public String loginForm(@CookieValue(value = "id"  ,required = false, defaultValue = "") String id, Model model) {
		model.addAttribute("id", id);  // 쿠키 값을 모델에 추가
		return "loginForm";  // loginForm.html  뷰 반환
	}


	@PostMapping(  "/login"  )
	public String login(String id, String pwd, boolean rememberId, HttpServletResponse response, HttpSession session) throws Exception {
		System.out.println("id=" + id);
		System.out.println("pwd=" + pwd);
		System.out.println("rememberId=" + rememberId);

		 
		if (!checkUser(id, pwd)) {
			String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다.", "utf-8");
			return "redirect:/login/login?msg=" + msg;   // param으로 msg내용을 확인할 수 있다
		}


		//로그인성공하면 세션에 저장
		session.setAttribute("sessionId", id);   // key, value

		if (rememberId) { //아이디 기억
			//쿠키 등록
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(60 * 60 * 24 * 30);  // 쿠키의 유효기간 설정 (30일)
			response.addCookie(cookie);
		} else {
			//쿠키 삭제
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(0);  // 쿠키를 삭제
			response.addCookie(cookie);
		}

		return "redirect:/home";    //등록이 완료되면 메인화면으로
	}

	private boolean checkUser(String id, String pwd) {
		// 테스트로, 실제로는 DAO의 기능을 써서 확인해야 함
		return "acorn".equals(id) && "1234".equals(pwd);
	}



	@RequestMapping("/logOut")
	public String logOut( HttpSession session) {
		session.invalidate();  // 세션 삭제  ////session.removeAttribute("loginID");   특정값만 삭제가능
		return "redirect:/home";
	}


}

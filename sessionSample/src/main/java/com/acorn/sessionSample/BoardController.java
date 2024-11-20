package com.acorn.sessionSample;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController{



   @RequestMapping("/list")
   public String list( HttpServletRequest request) {

       HttpSession session  = request.getSession(false);   //

       if (session == null ||  session.getAttribute("sessionId") == null) {
           return "redirect:/login/login";
       }
     return "boardList"  ;   
  }


}
package com.example.mybatisSqlsession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MemberController2 {


    @Autowired
    MemberService2 service;


    @GetMapping("/members2")
    public  @ResponseBody List<Member> getUser(){
        return  service.getMembers();
  }
}

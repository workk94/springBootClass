package com.example.mybatisSqlsession;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberService2Test {


    @Autowired
    MemberService service;

    @Test
    public  void test1(){
        Member member = new Member();
        member.setId(16);
        member.setName("hong");
        member.setEmail("hong@naver.com");
        service.registerMember(member);
    }
}

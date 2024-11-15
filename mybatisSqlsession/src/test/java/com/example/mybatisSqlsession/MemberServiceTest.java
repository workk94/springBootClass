package com.example.mybatisSqlsession;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {
    @Autowired
    private MemberService service;

    @Test
    public void test() {

        Member m = new Member();
        m.setId(21);
        m.setName("김우석");
        m.setEmail("ws94@gmail.com");
        service.registerMember(m);

        // transaction 테스트
        // 서비스 - register (등록, 오류발생, 등록)
        // @Transactional 트렌젝션 -> 전부 수행되지 않는다
        // 트렌젝션 x -> 일부만 수행된 상태로 남는다

    }
}
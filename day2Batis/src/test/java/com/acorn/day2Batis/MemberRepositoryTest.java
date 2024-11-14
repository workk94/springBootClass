package com.acorn.day2Batis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional // 테스트하고 자동으로 롤백처리함
//@Rollback(value = false) // value = false로 하면 롤백안함
class MemberRepositoryTest {

    @Autowired
    MemberRepository repository;

    @Test
    public void test(){

        Member m = new Member();
        m.setId("acorn5");
        m.setName("test5");
        m.setEmail("test5@acorn.com");
        int result = repository.insert(m);
        assertEquals(1, result);
    }
}
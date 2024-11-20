package com.acorn.mysqlTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository repository;

    @Test
    public void test() {
        List<Member> list =  repository.selectAll();
        assertTrue(list.size() >=1 );
    }
}
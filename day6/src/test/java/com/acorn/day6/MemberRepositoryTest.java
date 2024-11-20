package com.acorn.day6;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository repository;

    //@Test
    public void test1(){
        List<Member> list = repository.selectAllPage(1,2);
        assertTrue(list.size() >=1 );
    }


    @Test
    public void test2() {
        int totalCount = repository.countAll();
        assertEquals(11, totalCount);
    }
}
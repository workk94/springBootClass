package com.example.mybatisSqlsession;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional   //수행된 후 무조건 롤백처리된다
 //@Rollback( value = false)   // , 값을 직접확인하고 싶을 때 사용
class  MemberRepositoryTest {

    @Autowired
    MemberRepository repository;


   // @Test
    public  void test(){

        int size  = repository.findAll().size();
        assertTrue(  size >=0);
    }



    //@Test
    public  void test2(){

        Member member = new Member();
        member.setId(6);
        member.setName("hong5");
        member.setEmail("hong@naver.com");
        int size  = repository.insert( member);

        assertEquals(1, size);

    }

}
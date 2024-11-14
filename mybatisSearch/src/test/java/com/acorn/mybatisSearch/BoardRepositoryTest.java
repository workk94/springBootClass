package com.acorn.mybatisSearch;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardRepositoryTest {


    @Autowired
    BoardRepository repository;


    @Test
    public void  test1() throws Exception {
         SearchCondition condition  = new SearchCondition();
         condition.setCondition("title");
         condition.setKeyword( "자바");
          int size = repository.searchCondition(condition ).size();
          assertTrue( size>=1);
    }
}
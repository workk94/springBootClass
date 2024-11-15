package com.acorn.day3;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardRepositoryTest {
    @Autowired
    private BoardRepository repository;

    @Test
    public void test() {
        SearchCondition s = new SearchCondition();
        s.setKeyword("자바");
        s.setCondition("title");
        int result = repository.searchList(s).size();

        assertTrue(result >= 1);
    }
}
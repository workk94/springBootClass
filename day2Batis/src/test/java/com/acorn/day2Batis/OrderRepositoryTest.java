package com.acorn.day2Batis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class OrderRepositoryTest {
    @Autowired
    OrderRepository respository;

    @Test
    public void test() {
        int size = respository.selectAll().size();
        assertTrue(size >=1);
    }
}
package com.acorn.hello;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class Task1Test {


    @Autowired
    Task1 task;

    @Test
    public void test(){

        String result  =task.getnae();
        assertEquals("hi", result);

    }
}
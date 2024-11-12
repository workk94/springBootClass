package com.acorn.day1;

import org.springframework.stereotype.Service;

//@Componant
@Service
public class Task4Service {

    public Acorn getMember() {

        //
        Acorn acorn = new Acorn();
        acorn.setId("acorn1");
        acorn.setPw("1234");
        acorn.setName("test1");

        return acorn;
    }

}

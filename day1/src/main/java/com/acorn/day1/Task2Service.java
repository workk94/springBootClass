package com.acorn.day1;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Task2Service {

    public List<String> getdan3() {
        ArrayList<String> list = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            list.add(3 + " * " + i + " = " + 3 * i);
        }

        return list;
    }

    ;

}

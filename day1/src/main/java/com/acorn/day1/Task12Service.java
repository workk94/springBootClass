package com.acorn.day1;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Task12Service {

    public List<Food> getFoodList(){
        List<Food> foodList = new ArrayList<>();

        Food f1 = new Food();

        f1.setCode("f01");
        f1.setName("오므라이스");
        f1.setPrice(9000);

        Food f2 = new Food();

        f2.setCode("f02");
        f2.setName("돈까스");
        f2.setPrice(10000);

        Food f3 = new Food();

        f3.setCode("f03");
        f3.setName("국밥");
        f3.setPrice(11000);

        foodList.add(f1);
        foodList.add(f2);
        foodList.add(f3);

        return foodList;
    }

}

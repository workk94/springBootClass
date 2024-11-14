package com.example.batis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;



@Controller
public class UserController {


    @Autowired

    UserRepository  repository;




    @ResponseBody
    @GetMapping("/acornlist")
    public List<User> getUser() throws Exception {


        return  repository.selectAll();
    }
}

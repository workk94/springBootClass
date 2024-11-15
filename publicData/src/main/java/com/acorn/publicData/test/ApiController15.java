package com.acorn.publicData.test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class ApiController15 {



    @Autowired
    ApiExplorer15 api;

    @GetMapping(value = "/testapi" ,  produces = "application/json;charset=utf-8")
    public  String aa() throws IOException {

        return   api.getData();

    }
}

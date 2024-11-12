package com.acorn.hello;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BController {



    @GetMapping("/param1")
    public String a( String  paramData){


        System.out.println( paramData );

        return "view1";

    }


    @GetMapping("/param2")
    public String b(Integer paramData){

        System.out.println( paramData );


        return "view2";

    }
}

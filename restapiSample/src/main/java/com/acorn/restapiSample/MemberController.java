package com.acorn.restapiSample;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class MemberController {
    

    @GetMapping("/member-item")
    public String member1() {

        return "memberview";
    }




    @GetMapping("/member-list")
    public String member2() {

        return "memberlistview";
    }


    //
    @GetMapping("/member-register")
    public String member3(){

        return "memberRegister";
    }



    @GetMapping("/member-modify")
    public String member4(){

        return "memberUpdate";
    }


    @GetMapping("/member-delete")
    public String member5(){

        return "memberDelete";
    }


}

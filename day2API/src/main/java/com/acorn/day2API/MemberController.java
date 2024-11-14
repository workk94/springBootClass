package com.acorn.day2API;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    @GetMapping("/member-item")
    public String member1() {


        return "member";
    }

    @GetMapping("/member-list")
    public String member2() {
        return "memberlist";
    }

    @GetMapping("/member-register")
    public String member3() {

        return "memberRegister";
    }

    @GetMapping("/member-modify")
    public String member4() {
        return "memberUpdate";
    }

    //멤버 삭제
    @GetMapping("/member-delete")
    public String member5() {
        return "memberDelete";
    }
}

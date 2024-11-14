package com.acorn.restapiSample;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class RestAPIMemberController {




    //편리해진 json   응답

    @ResponseBody
    @GetMapping("/json")
    public String method() {
        return "americano";
    }



    @ResponseBody
    @GetMapping("/json3")
    public ArrayList<User> method4() {
        ArrayList<User> list = new ArrayList<>();
        list.add( new User("acorn1" ,"kim"));
        list.add( new User("acorn2" ,"lee"));
        list.add( new User("acorn3" ,"jun"));
        return list;
    }


    //#### 고객조회하기 #####

    @ResponseBody
    @GetMapping("/members/{id}")
    public User method2( @PathVariable String id ) {
        System.out.println( "id에 대한 고객 조회");
        User user = new User("acorn","0000");
        return user;
    }

    //##  고객전체조회

    @ResponseBody
    @GetMapping("/members")
    public ArrayList<User> method5() {
        System.out.println( "고객목록 데이터");
        ArrayList<User> list = new ArrayList<>();
        list.add( new User("acorn1" ,"kim"));
        list.add( new User("acorn2" ,"lee"));
        list.add( new User("acorn3" ,"jun"));
        return list;
    }


    //#### 고객등록 하기 #####

    @ResponseBody
    @PostMapping("/members")
    public String  method4( @RequestBody User user )   {
        System.out.println( user);
        System.out.println( "등록합니다");
        return "성공";
    }


    //#### 고객변경하기 #####
     @ResponseBody
     @PutMapping("/members/{id}")
    public String method5( @RequestBody User user ,  @PathVariable String id ) {
        System.out.println( user);
        System.out.println( id);
        System.out.println( "고객 정보를 수정합니다");
        return "수정성공";
    }




    //#### 고객삭제하기 #####
    @ResponseBody
    @DeleteMapping("/members/{id}")   //PathVariable
    public String method6(   @PathVariable String id ) {
        System.out.println( "고객 정보를 삭제합니다");
        System.out.println( id);
        return "삭제성공";
    }


}

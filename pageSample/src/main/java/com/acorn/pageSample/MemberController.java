package com.acorn.pageSample;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import page.PageHandler;


import java.util.*;

@Controller
public class MemberController {


    @Autowired
    MemberService service;

    @GetMapping("/list")
   public  String   getMembers( @RequestParam ( required = false , defaultValue = "1" , name="currentPage") Integer currentPage  , Model model){
    //public  String   getMembers(  Integer currentPage ){

        int size=2;
        int grpSize=5;
        int totalCount =0;

        List<Member> list  =  service.getMembers( currentPage , size );
        totalCount = service.getTotal();


        System.out.println( totalCount);
        PageHandler pageHandler = new PageHandler(currentPage ,totalCount, size, grpSize);


        model.addAttribute("members" , list);
        model.addAttribute("pageHandler" , pageHandler);

        return  "memberlist2";
    }


    @GetMapping("/test")
    public  String   test(   String  test ){
        System.out.println( test);
        return  "memberlist";
    }
}

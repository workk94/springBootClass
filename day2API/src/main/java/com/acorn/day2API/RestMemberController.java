package com.acorn.day2API;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Controller
public class RestMemberController {

    //데이터 응답하기
    @ResponseBody
    @GetMapping("/members/{id}")
    public Member method1(@PathVariable("id") String id){

        System.out.println(id);
        Member member = new Member();
        member.setId("acorn1");
        member.setName("test1");
        member.setEmail("test@acorn.com");
        return member;
    }

    @ResponseBody
    @GetMapping("/members")
    public ArrayList<Member> method2(){
        ArrayList<Member> list = new ArrayList<>();
        Member member1 = new Member();
        member1.setId("acorn1");
        member1.setName("test1");
        member1.setEmail("test1@google.com");

        Member member2 = new Member();
        member2.setId("acorn2");
        member2.setName("test2");
        member2.setEmail("test2@naver.com");

        list.add(member1);
        list.add(member2);

        return list;
    }


    //등록
    @ResponseBody
    @PostMapping("/members") // json문자열 -> 자바객체로 바인딩
    public String method3 (@RequestBody Member member) {
        System.out.println(member);

        return "등록성공";

    }

    //변경

    @ResponseBody
    @PutMapping("/members/{id}")
    public String member4(@PathVariable("id") String id, @RequestBody Member member) {

        System.out.println(id);
        System.out.println(member);

        return"수정성공";
    }

    //삭제
    @ResponseBody
    @DeleteMapping("/members/{id}")
    public String member5(@PathVariable("id") String id){
        ArrayList<Member> list = new ArrayList<>();
        Member member1 = new Member();
        member1.setId("acorn1");
        member1.setName("test1");
        member1.setEmail("test1@google.com");

        Member member2 = new Member();
        member2.setId("acorn2");
        member2.setName("test2");
        member2.setEmail("test2@naver.com");
        list.add(member1);
        list.add(member2);

        // 리스트를 순회하면서 id과 같은 멤버가 있다면 삭제 
        boolean result = list.removeIf(member -> member.getId().equals(id));
        if(!result){
            return "삭제실패";
        }
        return "삭제성공";
    }
}

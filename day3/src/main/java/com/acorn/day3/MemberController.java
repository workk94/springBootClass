package com.acorn.day3;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class MemberController {
    @Autowired
    MemberRepository repository;

    // 멤버가져오기
    @ResponseBody
    @GetMapping("/memberSearch")
    public List<Member> getMember (@RequestParam(name="userid") String[] userid){
        //System.out.println(Arrays.toString(userid));
        return null;
    }

    @ResponseBody
    @GetMapping("/members")
    public List<Member> getMember(){
        return repository.selectAll();
    }

    // 멤버가져오기
    @ResponseBody
    @GetMapping("/memberSearch2")
    public List<Member> getMember2 (@RequestParam(name="userid") String[] userid){
        //1. 사용자가 선택한 고객아이디 정보를 배열로 받는다
        //2. 배열을 리스트로 변환한다
        //3. 리포지토리의 리스트(고객 아이디 ) 고객정보를 반환하는 매서드를 호출한다
        //System.out.println(Arrays.toString(userid));

        // 배열을 List로 변환
        List<String> list = Arrays.asList(userid);
        return repository.searchSelect(list);
    }

    //


    // 선택한 고객의 정보를 view로 반환 하기
    @GetMapping("/memberSearch3")
    public String getMember3(@RequestParam(name = "userid") String[] userid, Model model) {
        //1.선택한 고객리스트 받아오기
        //2.배열을 리스트로 반환
        //3.repository로 부터 선택한 고객에 대한 고객정보 리스트 얻어오기
        //4.모델 저장하기
        System.out.println(userid);
        List<String> list = Arrays.asList(userid);
        List<Member> result = repository.searchSelect(list);
        model.addAttribute("result", result);
        return "memberview";
    }
}

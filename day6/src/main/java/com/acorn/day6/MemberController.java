package com.acorn.day6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MemberController {

    @Autowired
    MemberRepository repository;

    @GetMapping("/list")
    public String getMembers(@RequestParam(name = "currentPage", required = false, defaultValue = "1") int currentPage, Model model) {


        // pageSize, grpSize : 정하고 드러감
        int pageSize = 2;
        int grpSize = 5; // [1] [2] [3] [4] [5]
        int totalCount = 0;

        // 서비스 고객목록 (페이징 쿼리)
        List<Member> list = repository.selectAllPage(currentPage, pageSize);
        // 전체 고객수
        totalCount = repository.countAll();

        PageHandler handler = new PageHandler(currentPage, pageSize, totalCount, grpSize);

        model.addAttribute("list", list);
        model.addAttribute("pageHandler", handler);

        return "memberlist";
    }
}

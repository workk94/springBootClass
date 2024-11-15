package com.acorn.day3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BoardController {
    @Autowired
    BoardRepository repository;

    @GetMapping("/board")
    public String board (SearchCondition condition, Model model){
        System.out.println(condition);
        List<Board> list = repository.searchList(condition);
        model.addAttribute("list", list);
        return "list";
    }
}

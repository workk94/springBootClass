package com.acorn.thymeleafSample;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/thymeleaf")
public class thymeleafController {


    //이스케이프된 문자로 출력됨 ( 태그가 그대로 출력)

    @GetMapping("text")
    public String textBasic(Model model) {
        model.addAttribute("data", "Hello <b>Spring!</b>");
        return "thymeleaf/text-basic";
    }


    @GetMapping("utext")
    public String textUnescaped(Model model) {
        model.addAttribute("data", "Hello <b>Spring!</b>");
        return "thymeleaf/text-unescaped";
    }

    @GetMapping("/springEL")
    public String variable(Model model) {
        User userA = new User("김도현", 25);
        User userB = new User("김무궁", 30);

        List<User> list = new ArrayList<>();
        list.add(userA);
        list.add(userB);

        Map<String, User> map = new HashMap<>();
        map.put("acorn1", userA);
        map.put("acorn2", userB);

        model.addAttribute("user", userA);
        model.addAttribute("users", list);
        model.addAttribute("userMap", map);

        return "thymeleaf/variable";
    }



    @GetMapping("/date")
    public String date(Model model) {
        model.addAttribute("localDateTime", LocalDateTime.now());
        return "thymeleaf/date";
    }

    @GetMapping("link")
    public String link(Model model) {

        model.addAttribute("param1", "data1");
        model.addAttribute("param2", "data2");
        return "thymeleaf/link";

    }

    @GetMapping("/literal")
    public String literal(Model model) {
        model.addAttribute("data", "Spring!");
        return "thymeleaf/literal";
    }


    @GetMapping("/operation")
    public String operation(Model model) {
        model.addAttribute("data", "Spring!");
        model.addAttribute("data2", null);

        return "thymeleaf/operation";
    }

    @GetMapping("/attribute")
    public String attribute(  Model model) {
        model.addAttribute("flag1",true);
        model.addAttribute( "flag2" , false);

        return "thymeleaf/속성";
    }

    @GetMapping("/each")
    public String each(Model model) {

        //모델만들기
        List<User> list = new ArrayList<>();
        list.add(new User("김도현", 25));
        list.add(new User("김무궁", 25));
        list.add(new User("김세중", 26));

        model.addAttribute("users", list);


        return "thymeleaf/each";
    }

    @GetMapping("/condition")
    public String condition(Model model) {
        //
        List<User> list = new ArrayList<>();
        list.add(new User("김도현", 25));
        list.add(new User("김무궁", 25));
        list.add(new User("김세중", 26));

        model.addAttribute("users", list);
        return "thymeleaf/condition";
    }



    @GetMapping("/comments")
    public String comments(Model model) {
        model.addAttribute("data", "Spring!");
        return "thymeleaf/comments";
    }



    @GetMapping("/block")
    public String block(Model model) {
        //

        List<User> list = new ArrayList<>();
        list.add(new User("김도현", 25));
        list.add(new User("김무궁", 25));
        list.add(new User("김세중", 26));

        model.addAttribute("users", list);


        return "thymeleaf/block";
    }

    @GetMapping("/javascript")
    public String javascript(Model model) {

        model.addAttribute("user", new User("김정석", 30));


        List<User> list = new ArrayList<>();
        list.add(new User("김도현", 25));
        list.add(new User("김무궁", 25));
        list.add(new User("김세중", 26));

        model.addAttribute("users", list);

        return "thymeleaf/javascript";
    }




}

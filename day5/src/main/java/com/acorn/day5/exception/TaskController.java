package com.acorn.day5.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TaskController {

    @ResponseBody
    @GetMapping("/testServerErr")
    public void method(){
        
        //예외발생
        throw new RuntimeException("오류");
    }
}

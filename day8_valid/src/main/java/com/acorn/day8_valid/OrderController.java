package com.acorn.day8_valid;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class OrderController {


    //
    @GetMapping("/order")
    public String orderForm(@ModelAttribute Order order) {

        return "order-item";
    }

    //
    @PostMapping("/order")
    public String order(@ModelAttribute @Validated Order order, BindingResult bindingResult) {

        //

        //검증
        if (bindingResult.hasErrors()) {
            log.info("bindingResult={}", bindingResult);
            return "order-item";
        }
        return "redirect:/home";
    }
}

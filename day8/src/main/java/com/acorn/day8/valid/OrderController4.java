package com.acorn.day8.valid;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class OrderController4 {


    // validator를 가지고 스프링이 검증을 하게 하려면
    //1.Validator를 만든다 (Validator 인터페이스를 구현해야한다)
    //2.검증하려는 객체 앞에 @Validated 어노테이션 추가
    //3.사용자가 만든 Validator 등록

    @InitBinder
    public void init(WebDataBinder dataBinder) {
        dataBinder.addValidators(new OrderValidator());
    }

    //orderForm
    @GetMapping("/order4")
    //new Order()를 생성해서 model에 저장
    public String orderForm(@ModelAttribute Order order) {
        return "order-form4";
    }

    //order처리

    // 검증로직을 분리 => Validator 인터페이스를 구현한 클래스로 검증로직을 분리해보자

    @PostMapping("/order4")
    public String order(@ModelAttribute  @Validated  Order order, BindingResult bindingResult, Model model) {

        //오류가 있으면 다시 폼으로
        if (bindingResult.hasErrors()) {
            log.info("bindingResult={}", bindingResult);
            return "order-form4";
        }

        //service.registerOrder(order);
        return "redirect:/home";

    }
}

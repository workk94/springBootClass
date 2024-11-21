package com.acorn.beanValidSample;


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




    @GetMapping("/order")
    public  String  orderForm(  @ModelAttribute Order order){
        return "orderForm";
    }

    //주문 둥록


    @PostMapping("/order" )
    public  String  order(@Validated @ModelAttribute   Order  order , BindingResult bindingResult){

        log.info(   "errr={}"  , bindingResult);

        if( bindingResult.hasErrors()){
            System.out.println(   "error  발생 ");
            return "orderForm";
        }



        //성공화면  상품리스트 요청하기
        return  "redirect:/home";


    }
}

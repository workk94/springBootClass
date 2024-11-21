package com.acorn.validSample;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class OrderController5 {


    //global Validator가 적용됨

    @GetMapping("/order5")
    public  String  orderForm(  @ModelAttribute Order order){
        return "orderForm5";
    }

    //주문 둥록


    @PostMapping("/order5" )
    public  String  order(@Validated  @ModelAttribute   Order  order , BindingResult bindingResult){

        log.info(   "errr={}"  , bindingResult);

        if( bindingResult.hasErrors()){
            System.out.println(   "error  발생 ");
            return "orderForm5";
        }


        log.info( "등록완료={}" ,  order);


        //성공화면  상품리스트 요청하기
        return  "redirect:/home";


    }
}

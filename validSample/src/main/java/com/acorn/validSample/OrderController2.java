package com.acorn.validSample;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.File;


@Slf4j
@Controller
public class OrderController2 {


    //주문등록 화면


    @GetMapping("/order2")
    public  String  orderForm(  @ModelAttribute Order order){
        return "orderForm2";
    }

    //주문 둥록



    //BindingResult로  검증결과를 받아올 수있다
    //BindingResult에  검증오류 담기

    @PostMapping("/order2" )                        // //바인딩결과 담는다
                                                    // 위치 주의 해야 함
    public  String  order(@ModelAttribute   Order  order , BindingResult bindingResult){
        //검증
        //실패하면 주문등록화면
        //등록한 값 유지하기
        log.info(   "errr={}"  , bindingResult);


        if(   order.getName().isEmpty()){
            bindingResult.addError( new FieldError("order", "name" ,"상품 이름 입력하세요"));

            //@ModelAttribue 이름
            //field: 오류가발생한  필드 이름
            //defaultMessage : 오류 기본 메시지

        }

        if( order.getQty()==0)  {
            bindingResult.addError( new FieldError("order", "qty" ,   "수량을 1개 이상으로 입력하세요"));
        }

        if( order.getPrice()<=5000)  {
            bindingResult.addError( new FieldError("order", "price" ,   "단가를 확인하세요"));
        }

        if( order.getAmount()<=5000)  {
            bindingResult.addError( new FieldError("order", "amount" ,"금액을 확인하세요"));
        }


        if( bindingResult.hasErrors()){
            log.info( "erros={}" , bindingResult);
            System.out.println(   "error  발생 ");
            return "orderForm2";
        }


        //성공화면  상품리스트 요청하기
        return  "redirect:/home";


    }
}

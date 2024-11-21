package com.acorn.validSample;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
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



    //주문등록 화면
    /*

                • 해당 Controller로 들어오는 요청에 대해
				• 추가적인 설정을 하고 싶을 때 사용할 수 있다.
				• 모든 요청 전에InitBinder를 선언한 메소드가 실행된다.
     */

    @InitBinder

    public void init(WebDataBinder dataBinder){
        dataBinder.addValidators( new OrderValidator());

    }


    @GetMapping("/order4")
    public  String  orderForm(  @ModelAttribute Order order){
        return "orderForm4";
    }

    //주문 둥록



    //검증로직 Validator로 분리하기
    //@Validated 애너테이션을 사용해서 검증기를 통해서 검증을 해줌, 에러는 BindingResult에 담긴다
    //반드시 @Validated 애너테이션 추가해야함
    @PostMapping("/order4" )
    public  String  order(@Validated  @ModelAttribute   Order  order , BindingResult bindingResult){

        log.info(   "errr={}"  , bindingResult);

        if( bindingResult.hasErrors()){
            System.out.println(   "error  발생 ");
            return "orderForm4";
        }



        //성공화면  상품리스트 요청하기
        return  "redirect:/home";


    }
}

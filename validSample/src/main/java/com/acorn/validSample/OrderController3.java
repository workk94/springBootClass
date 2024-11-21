package com.acorn.validSample;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class OrderController3 {


    //주문등록 화면


    @GetMapping("/order3")
    public  String  orderForm(  @ModelAttribute Order order){
        return "orderForm3";
    }

    //주문 둥록


    @PostMapping("/order3" )
    public  String  order(@ModelAttribute   Order  order , BindingResult bindingResult){
        //검증
        //1)실패하면 주문등록화면
        //2)등록한 값을 유지하기


        //##원하는 에러코드 생성
        //에러메시지에 인자정보 전달

        log.info(   "errr={}"  , bindingResult);

        if(   order.getName().isEmpty()){
            bindingResult.addError( new FieldError("order", "name" , order.getName(),false, new String[]{"required"},null,"상품의 이름을 입력하세요"));
        }

        if( order.getQty()==0)  {
            bindingResult.addError( new FieldError("order", "qty" , order.getQty(), false, new String[]{ "qty.range"}, new Object[]{1, 1000},  "수량은 {0}개 이상 {1}개 이하로 입력하세요"));
        }

        if( order.getPrice()<=5000)  {
            bindingResult.addError( new FieldError("order", "price" , order.getPrice(), false, null, null,  "단가를 확인하세요"));
        }

        if( order.getAmount()<=5000)  {
            bindingResult.addError( new FieldError("order", "amount" , order.getAmount(), false, null, null,"금액을 확인하세요"));
        }


        if( bindingResult.hasErrors()){
            System.out.println(   "error  발생 ");
            return "orderForm3";
        }



        //성공화면  상품리스트 요청하기
        return  "redirect:/home";


    }
}

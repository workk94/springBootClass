package com.acorn.validSample;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class OrderController {


    //주문등록 화면


    @GetMapping("/order")
    public  String  orderForm( @ModelAttribute Order order){
        return "orderForm";
    }

    //주문 둥록


    @PostMapping("/order")
    public  String  order( @ModelAttribute   Order  order  , Model model){

        //검증
        //실패하면 주문등록화면
        Map<String, String> err = new HashMap<>();

        if (order.getName().isEmpty()) {
            err.put("name", "상품이름 입력하세요");
        }

        if (order.getQty() == 0) {
            err.put("qty", "수량을 1개 이상으로 입력하세요");
        }

        if (order.getPrice() <= 5000) {
            err.put("price", "단가를 확인하세요");
        }

        if (order.getAmount() <= 5000) {
            err.put("amount", "금액을 확인하세요");
        }

        if (!err.isEmpty()) {
            System.out.println("error 발생");
            // 에러 정보를 로그로 출력 (선택 사항)
            err.forEach((field, message) -> System.out.println(field + ": " + message));
            model.addAttribute("errors", err); // 에러 정보를 뷰에 전달
            return "orderForm";
        }



        return  "redirect:/home";
    }
}

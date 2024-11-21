package com.acorn.day8.valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;


@Controller
public class OrderController {

    //orderForm
    @GetMapping("/order")
    //new Order()를 생성해서 model에 저장
    public String orderForm(@ModelAttribute Order order){
        return "order-form";
    }

    //order처리
    @PostMapping("/order")
    public String order( @ModelAttribute Order order, Model model) {
        //검증에 실패하면 다시 order-form으로

        Map<String, String> erorrs = new HashMap<>();
        //이름검증
        //String str = null, String str = ""
        if(order.getName() == null || order.getName().isEmpty()){
            erorrs.put("name", "상품이름을 입력하세요");
        }
        //금액검증 100-10000
        if(order.getPrice() == null || order.getPrice()< 100 || order.getPrice() >10000){
            erorrs.put("price", "상품 금액은 100 ~ 10000 이어야 합니다 ");
        }

        //수량검증 999
        if(order.getQty() == null || order.getQty() > 999){
            erorrs.put("qty", "수량은 999를 초과할 수 없습니다");
        }

        if(!erorrs.isEmpty()){ // 검증에 실패한 상황
            model.addAttribute("errors", erorrs);
            return "order-form";
        }

        return "redirect:/home";

    }
}

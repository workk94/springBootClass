package com.acorn.validSample;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;

public class OrderValidator    implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
       // return clazz == Order.class;
          return Order.class.isAssignableFrom(clazz);
        //clazz가 Order 클래스이거나, Order의 자식클래스인지 확인
    }

    @Override
    public void validate(Object target, Errors errors) {


        Order order  = (Order) target;


        // 이름이 비어있는지 체크
        if (order.getName() == null || order.getName().isEmpty()) {
            errors.rejectValue("name", "required.name", null, "이름을 입력하세요");

        }

        //수량 체크
        if (order.getQty()<1 || order.getQty() >100 ) {
            errors.rejectValue("qty", "range.qty.error", new Object[]{1, 100}, "수량은 {0}개 이상 {1}개 이하로 입력하세요");
        }

        //금액
        if (order.getPrice() < 5000 || order.getPrice() >10000) {
            errors.rejectValue("price", "range.price.error", new Object[]{5000, 10000}, "가격은 {0} 이상 {1} 이하로 입력하세요");
        }




    }
}

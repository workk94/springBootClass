package com.acorn.day8.valid;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;

public class OrderValidator implements Validator {

    //Order와 Order를 상속한 객체만 검증이 되도록 수정

    //검증하려는 객체가 Order와 Order를 상속받은 객체인지를 판별함 true, false를 반환
    @Override
    public boolean supports(Class<?> clazz) {
        return Order.class.isAssignableFrom(clazz);
    }

    // Errors BindingResult의 부모타입
    @Override
    public void validate(Object target, Errors errors) {
        Order order = (Order)target;

        if (order.getName() == null || order.getName().isEmpty()) {
            //erorrs.put("name", "상품이름을 입력하세요");
            //bindingResult.addError(new FieldError("order", "name", "상품이름을 입력하세요"));
            //bindingResult.addError(new FieldError("order", "name", order.getName(), false, new String[]{"required"}, null, "상품이름을 입력하세요"));
            errors.rejectValue("name", "required");
        }
        //금액검증 100-10000
        if (order.getPrice() == null || order.getPrice() < 100 || order.getPrice() > 10000) {
            //erorrs.put("price", "상품 금액은 100 ~ 10000 이어야 합니다 ");
            //bindingResult.addError(new FieldError("order", "price", "상품 금액은 1000-10000원이어야한다"));
            //bindingResult.addError(new FieldError("order", "price", order.getPrice(), false, new String[]{"range.price"}, new Object[]{"200", "10000"}, "상품 금액은 100-10000이어야 한다"));
            errors.rejectValue("price", "range2", new Object[]{"200", "10000"}, "금액범위 오류");
        }

        //수량검증 999
        if (order.getQty() == null || order.getQty() > 999) {
            //erorrs.put("qty", "수량은 999를 초과할 수 없습니다");
            //bindingResult.addError(new FieldError("order", "qty", "수량은 999를 초과할 수 없습니다"));
            //bindingFailure : 실패여부x
            //bindingResult.addError(new FieldError("order", "qty", order.getQty(), false, null, null, "수량은 999를 초과할 수 없음"));
            errors.rejectValue("qty", "max2", new Object[]{"999"}, null);
        }

    }
}

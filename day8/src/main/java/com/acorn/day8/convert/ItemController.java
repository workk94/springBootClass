package com.acorn.day8.convert;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Controller
public class ItemController {

    /*
    * 해당 Controller로 들어오는 모든 요청에 대해서 추가적인 설정을 하고 싶을때 사용할 수 있다
    *
    * */

    @InitBinder
    public void init(WebDataBinder binder) {

        // String -> Date (yyyy/mm/dd => 자동으로 날짜형식으로 형변환을 해줌)
        SimpleDateFormat df = new SimpleDateFormat("yyyy/mm/dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
        binder.registerCustomEditor(String[].class, new StringArrayPropertyEditor("#"));
    }


    //item-form

    @GetMapping("/item")
    public String itemForm() {
        return "item-form";
    }

    //item 처리

    // BindingResult bindingResult 위치 중요함 -> 검증하는 객체 바로 뒤에 옴
    @PostMapping("/item")
    public String item(@ModelAttribute Item item, BindingResult bindingResult) {

        log.info("item={}", item);
        log.info("bindingResult={}", bindingResult);
        return "item-form";
    }
}

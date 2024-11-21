package com.acorn.day8.valid;

import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//OrderValidator를 GlobalValidator(전역)으로 등록하기
@Configuration
public class GlobalValidatorConfig implements WebMvcConfigurer {
    @Override
    public Validator getValidator() {

        //return WebMvcConfigurer.super.getValidator();

        return new OrderValidator();
    }
}

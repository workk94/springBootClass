package com.acorn.interceptorSample;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;



// @Configuration   설정등록 의미
@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionInterceptor())
                .addPathPatterns("/*.do", "/*.acorn")   //적용할 대상
                .order(3);



        registry.addInterceptor(new LogInterceptor())
                .addPathPatterns("/**")  //적용할 대상
                .excludePathPatterns("/css/**", "/js/**", "/images/**")  //제외대상  "/login.do" ,
                .order(2);//



        registry.addInterceptor( new TestInterceptor())
                .addPathPatterns("/**").order(1);


    }
}

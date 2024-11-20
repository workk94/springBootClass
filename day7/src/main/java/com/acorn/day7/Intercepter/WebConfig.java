package com.acorn.day7.Intercepter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(new TestInterceptor())
                .addPathPatterns("/**")
                .order(1);

        registry.addInterceptor(new SessionInterceptor())
                .addPathPatterns("/acornOrder", "/acornHome")
                .order(2);
    }
}

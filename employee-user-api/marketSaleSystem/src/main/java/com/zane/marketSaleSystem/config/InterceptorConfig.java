package com.zane.marketSaleSystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.zanewnch.LoginInterceptor;


//@Configuration
public class InterceptorConfig implements WebMvcConfigurer {


    private final LoginInterceptor loginInterceptor;

    @Autowired
    public InterceptorConfig(LoginInterceptor loginInterceptor) {
        this.loginInterceptor = loginInterceptor;

    }

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
//
//        /*
//        配置要攔截的請求路徑
//        要注意的是：他是要寫請求路徑！
//        也就是/api/**
//
//        不要寫成前端的route
//         */
//
        interceptorRegistry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/api/users/login");
//        add another interceptor
//        interceptorRegistry.addInterceptor();

    }
}

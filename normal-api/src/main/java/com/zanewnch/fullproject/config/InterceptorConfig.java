package com.zanewnch.fullproject.config;

import com.zanewnch.fullproject.interceptor.LoginCheckInterceptor;
import com.zanewnch.fullproject.interceptor.SecondTestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
Add @Configuration, the spring boot would auto recognize this class as a configuration class, which also invoke the interceptor.
 */
/*
因為前端還沒有寫好  所以先不用 interceptor
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private LoginCheckInterceptor loginCheckInterceptor;

    @Autowired
    private SecondTestInterceptor secondTestInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*
        當有多個interceptor的時候，就是根據addInterceptor的順序來決定先後
         */

/*
This method is IDE default provided
 */
        //        WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(loginCheckInterceptor)
//                intercept which path
                .addPathPatterns("/**")
//                exclude which path
                .excludePathPatterns("/login");registry.addInterceptor(secondTestInterceptor).addPathPatterns("/**");

    }
}

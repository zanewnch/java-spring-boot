package com.zanewnch.fullproject.config;

import org.dom4j.io.SAXReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {

    //    declare third-party bean
    //     put the return value of this method into IOC container, which mean can use @autowired to inject this class.
    @Bean
    public SAXReader saxReader() {
        return new SAXReader();
    }
}

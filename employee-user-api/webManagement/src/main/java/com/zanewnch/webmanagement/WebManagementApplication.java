package com.zanewnch.webmanagement;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.zanewnch.TestComponent;

/*
所有獨立module的file都是放在各自個org.zanewnch, 然後我只要使用@ComponentScan({"org.zanewnch"}) spring就會自動scan 解決問題.

@Import 是第二種方法 可以一個一個輸入component

 */
//@Import({TestComponent.class})
//@MapperScan({"org.zanewnch.mapper","com.zanewnch"})
@ComponentScan({"org.zanewnch","com.zanewnch"})
@SpringBootApplication
public class WebManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebManagementApplication.class, args);
    }

}

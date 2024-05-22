package com.zane.marketSaleSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"org.zanewnch","com.zanewnch","com.zane","org.zane"})
@SpringBootApplication
public class MarketSaleSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarketSaleSystemApplication.class, args);
    }

}

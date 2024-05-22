package com.zanewnch.springboot1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*
@SpringBootApplication which include @ComponentScan,
the @ComponentScan scan the bean which app need, and the range of scan is the package @SpringBootApplication at and its sub-package
 */
public class Springboot1Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot1Application.class, args);
    }

}

package com.zanewnch.webmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.zanewnch.TestComponent;

@RestController
public class TestController {

    private final TestComponent testComponent;

    @Autowired
    public TestController(TestComponent testComponent){
        this.testComponent = testComponent;
    }
}

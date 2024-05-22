package com.zanewnch.fullproject.controller;

import com.zanewnch.fullproject.model.Emp;
import com.zanewnch.fullproject.service.EmpService;
import com.zanewnch.fullproject.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping
    public Result login(@RequestBody Emp emp){
        log.info("employee login: {}", emp);

        Emp e = empService.login(emp);

        return e!=null?Result.success():Result.error("Login failed");
    }
}

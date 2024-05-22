package com.zanewnch.webmanagement.controller;

import com.zanewnch.webmanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zanewnch.Employee;
import org.zanewnch.Result;

import java.time.LocalDateTime;
import java.util.List;

/*
如果有配置 crossConfig, 就不用再個別的controller 加上 @CrossOrigin
 */
//@CrossOrigin(allowedHeaders = {"Content-Type", "Token"})
@RequestMapping("/api/employees")
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public Result selectAllEmployees() {

        return Result.success(employeeService.selectAllEmployees());
    }

    //    在實際開發當中通常都是分頁查詢，所以我這裡雖然只寫了selectEmployees, 但其實使用了pageHelper library，如果不使用pageHelper就要使用原始的sql console limit syntax

    //    pageNum 就是currentPage 當前頁數
    //    pageSize 就是單一分頁要顯示多少條數據
    @GetMapping(params = {"pageNum", "pageSize"})
    public Result selectEmployeesWithPagination(
            @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
    ) {
        return Result.success(employeeService.selectEmployeesWithPagination(pageNum, pageSize));
    }

    @GetMapping
    public Result selectEmployees(
            @RequestParam(name = "id", required = false) Integer id,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "number", required = false) Integer number,
            @RequestParam(name = "age", required = false) Integer age,
            @RequestParam(name = "gender", required = false) String gender,
            @RequestParam(name = "createTime", required = false) LocalDateTime createTime,
            @RequestParam(name = "updateTime", required = false) LocalDateTime updateTime
    ) {
        return Result.success(employeeService.selectEmployees(id,name,number,age,gender,createTime,updateTime));
    }

}

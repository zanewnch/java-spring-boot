package com.zanewnch.fullproject.controller;

import com.github.pagehelper.PageHelper;
import com.zanewnch.fullproject.annotation.Log;
import com.zanewnch.fullproject.mapper.EmpMapper;
import com.zanewnch.fullproject.model.Emp;
import com.zanewnch.fullproject.model.PageBean;
import com.zanewnch.fullproject.service.EmpService;
import com.zanewnch.fullproject.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/*
Using @RequestMapping annotation, then there is not necessary to add path to annotation of method
 */
@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {
    /*
    step 1: add @RestController
    step 2: add @Autowired (The next layer)
    step 3: add @RequestMapping (get, post, put, delete)
     */

    @Autowired
    private EmpService empService;


    @GetMapping("/allEmp")
    public Result selectAllEmp(){
     List<Emp> list =  empService.selectAllEmp();
     return Result.success(list);

    }



//    The valueExample = 10, which is assigned in application.properties; using @Value to get the value
    @Value("${valueExample.Integer}")
    private String valueExample;

    /**
     * controller 的method 是return Result object
     */
//    @GetMapping("/emps")
//    @GetMapping("/list")
//    public Result list() {
//        return Result.success(empService.list());
//    }

    /*
    The way of frontend to pass parameter to backend is using query string,
    and the page parameter is the number of current page, and pageSize
     parameter is the number of data per page.

    The parameterName received need to same as frontend parameterName
    for example:
    frontend query string is : ?page=1&pageSize=10
    then backend parameterName need to be: Integer page, Integer pageSize
     */
    /*
    @RequestParam(defaultValue = "1") 是將frontend pass 的parameter setting default value, if frontend pass null, then use default value
     */
//    @GetMapping("/emps")
    @GetMapping("/page")
    public Result page(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {

        log.info("Select data of employee by page : " + page + " and pageSize : " + pageSize);


        PageBean pageBean = empService.page(page, pageSize);

        return Result.success(pageBean);


    }

    /*
    This api is using pageHelper to do pagination, and its result is same as api of page(limit  (page-1)*pageSize, pageSize)
     */
    @GetMapping("/pageHelper")
    public Result pageHelper(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {

        log.info("Select data of employee by page : " + page + " and pageSize : " + pageSize);

        PageBean pageBean = empService.pageHelper(page, pageSize);

        return Result.success(pageBean);
    }

    /*
    Completed syntax with query string parameter, pageHelper, SQL condition
     */
    /*
    I want to create a method which name is completedPageHelper, it receives parameter by query string pass from frontend, so using @RequestParam; the parameter are following below:
    Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end.
    For begin and end parameter, I want to add @DateTimeFormate(pattern="yyy-mm-dd") annotation.
    the content of method are following below:
    1. declare a pageBean with type of PageBean, and which value is empService.completedPageHelper(page,pageSize,name,gender,begin,end).
    2. return Result.success(pageBean)
     */
    @GetMapping("/emps")
    public Result completedPageHelper(@RequestParam Integer page, @RequestParam Integer pageSize, @RequestParam(required = false) String name, @RequestParam(required = false) Short gender, @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin, @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end
    ) {
        // 1. Declare a pageBean with type of PageBean, and set its value using empService.completedPageHelper method.
        PageBean pageBean = empService.completedPageHelper(page, pageSize, name, gender, begin, end);

        // 2. Return Result.success(pageBean)
        return Result.success(pageBean);
    }

    @DeleteMapping("/{ids}")
    public Result deleteEmp(@PathVariable Integer ids
    ){

        empService.deleteEmp(ids);
    return Result.success();
    }

    /*
    Receive a json file,
    so need to use @RequestBody annotation
     */
    @PostMapping
    public Result addEmp(
        @RequestBody Emp emp
    ){
        log.info("add the new employee data :" + emp);
        empService.addEmp(emp);

        return Result.success();
    }

}

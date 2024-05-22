package com.zanewnch.webmanagement.controller;

import com.zanewnch.webmanagement.service.UserServiceTest;
import org.springframework.web.bind.annotation.*;
import org.zanewnch.Result;
import org.zanewnch.User;

/*
This controller is course example
 */

/*
get, post, put, delete
 */

//@RequestMapping("/api/users")
//@RestController
public class UserControllerTest {

    private final UserServiceTest userService;
    public UserControllerTest(UserServiceTest userService){
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public Result selectById(@PathVariable Long id){
        return Result.success(userService.selectById(id));
    }

    @GetMapping("/{number}")
    public Result selectByNumber(@PathVariable Long number){
        return Result.success(userService.selectByNumber(number));
    }

    @GetMapping
    public Result selectAllUser(){
        return Result.success(userService.selectAllUser());
    }

    @PostMapping
    public Result insertUser(@RequestBody User user){
        userService.insertUser(user);
        return Result.success();
    }

    @PutMapping
    public Result updateUser(@RequestBody User user){
        userService.updateUser(user);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Long id){
        userService.deleteById(id);
        return Result.success();
    }


}

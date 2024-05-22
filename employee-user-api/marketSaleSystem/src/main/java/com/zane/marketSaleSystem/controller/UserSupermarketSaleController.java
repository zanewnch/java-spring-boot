package com.zane.marketSaleSystem.controller;

import com.zane.marketSaleSystem.mapper.UserSupermarketSaleMapper;
import com.zane.marketSaleSystem.service.UserSupermarketSaleService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zanewnch.Result;
import org.zanewnch.entity.UserSupermarketSale;
import org.zanewnch.JwtUtils;

import java.util.HashMap;
import java.util.Map;

/*
multiple controller can not use the same @RequestMapping path
 */
@RestController
@RequestMapping("/api/UsersupermarketSale")
public class UserSupermarketSaleController {
    private final UserSupermarketSaleService userSupermarketSaleService;

    @Autowired
    public UserSupermarketSaleController(UserSupermarketSaleService userSupermarketSaleService) {
        this.userSupermarketSaleService = userSupermarketSaleService;
    }


    /*
Although frontend only pass two parameters, but if the request parameter name is equal to object field name, it would still be correct
 */
    @PostMapping("/login")
    public Result<String> login(@RequestBody UserSupermarketSale userSupermarketSale, HttpServletRequest request
    ) {


        System.out.println(request.getParameter("username"));

        // 1. get username and password from request body


        // 2. check if username and password are correct through select
        if (userSupermarketSaleService.login(userSupermarketSale.getUsername(), userSupermarketSale.getPassword())) {
            // 3. if correct, generate token and return to frontend

            Map<String, Object> map = new HashMap<>();
            map.put("username", userSupermarketSale.getUsername());
            String jwtToken = JwtUtils.generateJwt(map);
            return Result.success(jwtToken);

        } else {
            // 4. if not correct, return error message
            return Result.error("username or password is not correct");
        }

    }

    @PostMapping("/register")
    public Result<String> register(@RequestBody UserSupermarketSale userSupermarketSale, HttpServletRequest request
    ) {
        return userSupermarketSaleService.register(userSupermarketSale) ? Result.success() : Result.error("username already exists");
    }

}


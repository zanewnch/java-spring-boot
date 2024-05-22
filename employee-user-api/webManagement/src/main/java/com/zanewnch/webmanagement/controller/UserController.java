package com.zanewnch.webmanagement.controller;

import com.zanewnch.webmanagement.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zanewnch.Result;
import org.zanewnch.SignInToken;
import org.zanewnch.User;
import org.zanewnch.JwtUtils;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
前端interceptor 傳request 的時候在request header 加上 token key,然後backend 要receive, receive有兩個步驟要做：

 1.允許跨域request 包含token 這個request header key, 要在controller 加上@CrossOrigin
 2. method 要加上 @RequestHeader("token") String token

 !!! 3. 但如果有了global CORS config 就不需要在個別controller 加上@CrossOrigin

 */
@CrossOrigin(allowedHeaders = {"Content-Type", "Token"})
@RequestMapping("/api/users")
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Result selectUsers(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) LocalDateTime createTime,
            @RequestParam(required = false) LocalDateTime updateTime
    ) {
        /*
        if select failure it would return the empty list,but I already detect the empty list in backend, so if the select failure, the backend sends null data to frontend not empty array(in json); so the frontend condition determination just uses null to determine(not this.fetchData.length === 0).5
         */
        if (userService.selectUsers(id, username, password, createTime, updateTime).isEmpty()) {
            return Result.error("false");
        } else {
            return Result.success(userService.selectUsers(id, username, password, createTime, updateTime));
        }

    }
    /*
    比較好的做法就是登入token 要用cookie傳，然後cookie 要加上secure and httponly,
    但是因為不知道具體的寫法，為了效率我先直接把token 傳在response body
     */

    // 登入的時候要backend 要response jwt token
    // 但檢查authenticate 是不需要token to be parameter的
    @PostMapping("/signIn")
    public Result signInAuthenticate(@RequestBody User user,
                                     HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                     @RequestHeader("Token") String token) {
        /*
         print user for example:
         User(id=null, username=admin, password=null, createTime=null, updateTime=null)
         */
        List<User> result = userService.selectUsers(user.getId(), user.getUsername(), user.getPassword(), user.getCreateTime(), user.getUpdateTime());


        // print cookie token to detect whether success
        System.out.println(token);


        // 如果jwtToken過期 就會出現ExpiredJwtException, 然後應該用try-catch來處理，如果有exception 就要返回給前端錯誤碼
//        System.out.println(JwtUtils.parseJwt(token));


        // 教程的做法是把jwt token 直接設在entity裡面 傳給前端

        if (result.isEmpty()) {
            return Result.error("false");
        } else {

            // generate the jwt token
            Map<String, Object> registerInformation = new HashMap<>();

            registerInformation.put("username", user.getUsername());

            SignInToken signInToken = new SignInToken(JwtUtils.generateJwt(registerInformation));


            // 登入成功，傳token過去
            /*
            如果傳signInToken, frontend收到{
            "token":"tokenValue"}

            如果傳signInToken.token,frontend收到
            "tokenValue"
             */
            return Result.success(signInToken);


        }

    }

    @PostMapping("/signUp")
    public Result signUpAuthenticate(
            @RequestBody User user
    ) {
        List<User> result = userService.signUpAuthenticate(user.getId(), user.getUsername(), user.getPassword(), user.getCreateTime(), user.getUpdateTime());

        /*
        如果 result為空，代表沒有existed data,就成功insert data; 如果existed 就insert失敗
         */
        if (result.isEmpty()) {
            return Result.success();
        } else {

            return Result.error("The data is already existed.");
        }
    }
}

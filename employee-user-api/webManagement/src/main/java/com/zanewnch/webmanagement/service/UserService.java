package com.zanewnch.webmanagement.service;

import org.zanewnch.User;

import java.time.LocalDateTime;
import java.util.List;

public interface UserService {
    List<User> selectUsers(
            Integer id,
            String username,
            String password,
            LocalDateTime createTime,
            LocalDateTime updateTime
    );

    List<User> signUpAuthenticate(
            Integer id,
            String username,
            String password,
            LocalDateTime createTime,
            LocalDateTime updateTime
    );
}


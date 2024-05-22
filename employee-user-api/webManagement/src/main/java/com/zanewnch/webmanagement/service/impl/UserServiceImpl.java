package com.zanewnch.webmanagement.service.impl;

import com.zanewnch.webmanagement.mapper.UserMapper;
import com.zanewnch.webmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zanewnch.User;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    @Autowired
    UserServiceImpl(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @Override
    public List<User> selectUsers(
            Integer id,
            String username,
            String password,
            LocalDateTime createTime,
            LocalDateTime updateTime
    ){
        return userMapper.selectUsers(id,username,password,createTime,updateTime);
    }

    @Override
    public List<User> signUpAuthenticate(
            Integer id,
            String username,
            String password,
            LocalDateTime createTime,
            LocalDateTime updateTime
    ){
        List<User> result = userMapper.selectUsers(id, username, password, createTime, updateTime);

        /*
         detect whether the table has existed data.
         whether result.isEmpty() then return result
         */
        if (result.isEmpty()){
            // if not existed, then insert data
            userMapper.insertUsers(id,username,password,createTime,updateTime);

        }

        return result;
    }
}

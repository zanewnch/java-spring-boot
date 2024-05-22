package com.zanewnch.webmanagement.service.impl;

import com.zanewnch.webmanagement.mapper.UserMapperTest;
import com.zanewnch.webmanagement.service.UserServiceTest;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.zanewnch.User;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImplTest implements UserServiceTest {

    private UserMapperTest userMapper;
    public UserServiceImplTest(UserMapperTest userMapper){
        this.userMapper = userMapper;
    }

    @Override
    public void insertUser(User user){
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userMapper.insertUser(user);
    }

    @Override
    public void updateUser(User user){
        user.setUpdateTime(LocalDateTime.now());

        userMapper.updateUser(user);
    }

    @Override
    public void deleteById(@Param("id") Long id){
        userMapper.deleteById(id);
    }

    @Override
    public List<User> selectById(@Param("id") Long id){
        return userMapper.selectById(id);
    }

    @Override
    public List<User> selectByNumber(@Param("number") Long number){
        return userMapper.selectByNumber(number);
    }

    @Override
    public List<User> selectAllUser(){
        return userMapper.selectAllUser();
    }




}

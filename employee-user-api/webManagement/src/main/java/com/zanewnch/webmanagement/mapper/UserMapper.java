package com.zanewnch.webmanagement.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.zanewnch.User;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface UserMapper {
    List<User> selectUsers(Integer id,
                           String username,
                           String password,
                           LocalDateTime createTime,
                           LocalDateTime updateTime);

    @Insert("insert into users(username, password,createTime, updateTime) values(#{username},#{password},now(),now()) ")
    void insertUsers(Integer id,
                           String username,
                           String password,
                           LocalDateTime createTime,
                           LocalDateTime updateTime);
}

package com.zanewnch.webmanagement.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zanewnch.User;

import java.util.List;

@Mapper
public interface UserMapperTest {
    void insertUser(User user);

    void updateUser(User user);

    void deleteById(Long id);

    List<User> selectById(Long id);

    List<User> selectByNumber(Long number);

    List<User> selectAllUser();

    void insertRandomDataToTable(User user);
}

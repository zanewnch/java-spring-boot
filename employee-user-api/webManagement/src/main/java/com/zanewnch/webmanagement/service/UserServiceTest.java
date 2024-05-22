package com.zanewnch.webmanagement.service;
import org.apache.ibatis.annotations.Param;
import org.zanewnch.User;

import java.util.List;

public interface UserServiceTest {
    void insertUser(User user);
    void updateUser(User user);
    void deleteById(@Param("id") Long id);
    List<User> selectById(@Param("id") Long id);
    List<User> selectByNumber(@Param("number") Long number);
    List<User> selectAllUser();
}

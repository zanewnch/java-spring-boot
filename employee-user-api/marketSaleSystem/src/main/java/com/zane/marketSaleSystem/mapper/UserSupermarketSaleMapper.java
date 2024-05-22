package com.zane.marketSaleSystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.zanewnch.annotation.AutoFill;
import org.zanewnch.entity.UserSupermarketSale;
import org.zanewnch.enumeration.DbOperationType;

import java.util.List;

@Mapper
public interface UserSupermarketSaleMapper {

    @Select("select * from user where username = #{username} and password = #{password}")
    List<UserSupermarketSale> login(String username, String password);

    List<UserSupermarketSale> get(UserSupermarketSale userSupermarketSale);

    List<UserSupermarketSale> getByUsername(String username);

    @AutoFill(DbOperationType.INSERT)
    void create(UserSupermarketSale userSupermarketSale);

    @AutoFill(DbOperationType.UPDATE)
    void update(UserSupermarketSale userSupermarketSale);

    void delete(String username);


}

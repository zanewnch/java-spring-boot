package com.zane.marketSaleSystem.service.impl;

import com.zane.marketSaleSystem.mapper.SupermarketSaleMapper;
import com.zane.marketSaleSystem.mapper.UserSupermarketSaleMapper;
import com.zane.marketSaleSystem.service.UserSupermarketSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zanewnch.entity.SupermarketSale;
import org.zanewnch.entity.UserSupermarketSale;

// The method description should be written in the interface

@Service
public class UserSupermarketSaleServiceImpl implements UserSupermarketSaleService {

    private final UserSupermarketSaleMapper userSupermarketSaleMapper;

    @Autowired
    public UserSupermarketSaleServiceImpl(UserSupermarketSaleMapper userSupermarketSaleMapper){
        this.userSupermarketSaleMapper = userSupermarketSaleMapper;
    }

    @Override
    public boolean login(String username, String password){
        return userSupermarketSaleMapper.login(username, password) != null;
    }


    @Override
    public boolean register(UserSupermarketSale userSupermarketSale){


        // 1. check if username exists by select
        if (userSupermarketSaleMapper.getByUsername(userSupermarketSale.getUsername()).size() != 0){
            // if not null, which means username exists,so return false
            return false;
        }else{
            // 2. if not exists, insert into new user data
            userSupermarketSaleMapper.create(userSupermarketSale);
            return true;
        }





    }
}

package com.zane.marketSaleSystem.service;

import org.zanewnch.entity.SupermarketSale;
import org.zanewnch.entity.UserSupermarketSale;

// The method description should be written in the interface
public interface UserSupermarketSaleService {
    boolean login(String username, String password);

    /**
     * Detect if username exists, if not, insert into new user data
     * @param userSupermarketSale userSupermarketSale
     * @return true if register successfully, false if username exists
     */
    boolean register(UserSupermarketSale userSupermarketSale);
}

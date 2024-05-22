package org.zane.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zane.entity.SupermarketSale;
import org.zane.server.mapper.SupermarketSaleMapper;
import org.zane.server.service.SupermarketSaleService;

import java.util.List;

@Service
public class SupermarketSaleServiceImpl implements SupermarketSaleService {

    private final SupermarketSaleMapper supermarketSaleMapper;

    @Autowired
    public SupermarketSaleServiceImpl(SupermarketSaleMapper supermarketSaleMapper) {
        this.supermarketSaleMapper = supermarketSaleMapper;
    }

    @Override
    public List<SupermarketSale> get() {
        return supermarketSaleMapper.get();

    }
}

package com.zane.marketSaleSystem.service;
import org.zanewnch.PageBean;
import org.zanewnch.entity.SupermarketSale;
import java.util.List;

public interface SupermarketSaleService {
    List<SupermarketSale> get();
    PageBean<List<SupermarketSale>> getByPage(Integer pageNum, Integer pageSize);

    void create(SupermarketSale supermarketSale);

    void update(SupermarketSale supermarketSale);

    void delete(int id);


}

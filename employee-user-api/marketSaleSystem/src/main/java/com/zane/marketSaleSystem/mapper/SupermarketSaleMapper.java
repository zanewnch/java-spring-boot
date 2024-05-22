package com.zane.marketSaleSystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.zanewnch.entity.SupermarketSale;
import org.zanewnch.entity.UserSupermarketSale;

import java.util.List;

@Mapper
public interface SupermarketSaleMapper {
    List<SupermarketSale> get();

    @Select("select * from supermarket where id = #{id}")
    List<SupermarketSale> getById(Long id);


    @Select("select * from supermarket")
    List<SupermarketSale> getByPage(Integer pageNum, Integer pageSize);

    void create(SupermarketSale supermarketSale);

    void update(SupermarketSale supermarketSale);

    void delete(int id);
}

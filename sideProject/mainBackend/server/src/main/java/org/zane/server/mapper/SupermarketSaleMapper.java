package org.zane.server.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zane.entity.SupermarketSale;

import java.util.List;

@Mapper
public interface SupermarketSaleMapper {

    List<SupermarketSale> get();
}

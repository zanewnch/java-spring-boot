package com.zane.marketSaleSystem.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zane.marketSaleSystem.mapper.SupermarketSaleMapper;
import com.zane.marketSaleSystem.service.SupermarketSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zanewnch.PageBean;
import org.zanewnch.entity.SupermarketSale;
import java.util.List;

@Service
public class SupermarketSaleServiceImpl implements SupermarketSaleService {

    private final SupermarketSaleMapper supermarketSaleMapper;

    @Autowired
    public SupermarketSaleServiceImpl(SupermarketSaleMapper supermarketSaleMapper){
        this.supermarketSaleMapper = supermarketSaleMapper;
    }

    @Override
    public List<SupermarketSale> get() {
        return supermarketSaleMapper.get();
    }

    @Override
    public PageBean<List<SupermarketSale>> getByPage(Integer pageNum, Integer pageSize){

          PageHelper.startPage(pageNum, pageSize);
        //        PageMethod.startPage(pageNum, pageSize);

        Page<SupermarketSale> page = (Page<SupermarketSale>) supermarketSaleMapper.getByPage(pageNum, pageSize);

        return new PageBean<>(page.getTotal(), page.getResult());

    }

    @Override
    public void create(SupermarketSale supermarketSale){
        supermarketSaleMapper.create(supermarketSale);
    }
    @Override
    public void update(SupermarketSale supermarketSale){

        if(supermarketSaleMapper.getById(supermarketSale.getId()).size() != 0){
            supermarketSaleMapper.update(supermarketSale);
        }else{
            throw new RuntimeException("id不存在");
        }

    }
    @Override
    public void delete(int id){
        supermarketSaleMapper.delete(id);
    }


}

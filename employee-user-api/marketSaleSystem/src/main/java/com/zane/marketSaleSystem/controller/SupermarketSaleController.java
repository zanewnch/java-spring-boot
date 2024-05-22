package com.zane.marketSaleSystem.controller;

import com.zane.marketSaleSystem.service.SupermarketSaleService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zanewnch.JwtUtils;
import org.zanewnch.PageBean;
import org.zanewnch.Result;
import org.zanewnch.entity.SupermarketSale;
import org.zanewnch.entity.UserSupermarketSale;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// crud: test finished

@RestController
@RequestMapping("/api/supermarketSale")
public class SupermarketSaleController {
    private final SupermarketSaleService supermarketSaleService;


    @Autowired
    public SupermarketSaleController(SupermarketSaleService supermarketSaleService) {
        this.supermarketSaleService = supermarketSaleService;
    }

    @GetMapping
    public Result<List<SupermarketSale>> get() {
        return Result.success(supermarketSaleService.get());
    }

    @GetMapping(params = {"pageNum", "pageSize"})
    public Result<PageBean<List<SupermarketSale>>> getByPage(
            @RequestParam(required = true) Integer pageNum,
            @RequestParam(required = true)
            Integer pageSize) {

        return Result.success(supermarketSaleService.getByPage(pageNum, pageSize));
    }

    @PostMapping
    public Result<String> create(@RequestBody SupermarketSale supermarketSale) {
        supermarketSaleService.create(supermarketSale);
        return Result.success();
    }

    @PutMapping
    public Result<String> update(@RequestBody SupermarketSale supermarketSale) {
        supermarketSaleService.update(supermarketSale);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result<String> delete(@PathVariable int id) {
        supermarketSaleService.delete(id);
        return Result.success();
    }

    // todo: customized exception class



}


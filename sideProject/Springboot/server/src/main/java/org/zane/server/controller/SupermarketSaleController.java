package org.zane.server.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zane.Result;
import org.zane.server.service.SupermarketSaleService;

import java.util.List;


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

    }

}

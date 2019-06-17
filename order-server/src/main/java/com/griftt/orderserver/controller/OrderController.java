package com.griftt.orderserver.controller;

import com.griftt.common.entity.Goods;
import com.griftt.common.entity.Order;
import com.griftt.common.feign.GoodsFeign;
import com.griftt.common.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private GoodsFeign goodsFeign;

    @PostMapping("/list")
    public List<Order> getOrder(){
        return  orderService.getOrderById(56);
    }

    @RequestMapping("test")
    public String test(){
        return "ok";
    }


    @GetMapping("/goods")
    public List<Goods> getOrderGoods(){
        List<Goods> goodsList = goodsFeign.getGoodsList();
        log.info("goods={}",goodsList);
        return goodsList;
        //return  goodsFeign.getGoodsList();
    }
}

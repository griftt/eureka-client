package com.griftt.eurekaclient.feign;

import com.griftt.eurekaclient.entity.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "eureka-product")
public interface GoodsFeign {

    @GetMapping("/goods/all")
    public List<Goods> getGoodsList();
}

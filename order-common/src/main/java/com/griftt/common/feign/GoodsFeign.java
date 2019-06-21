package com.griftt.common.feign;

import com.griftt.common.entity.GoodsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

//@FeignClient(name = "product")
public interface GoodsFeign {

    @GetMapping("/goods/all")
    public List<GoodsDto> getGoodsList();

    @GetMapping("/goods/one")
    public GoodsDto getGoodsById(Integer id);
}

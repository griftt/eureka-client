package com.griftt.common.service;

import com.griftt.common.entity.Order;

public interface OrderGoodsService {

   /**
    * 下单扣库存
    * @param goodsId
    * @param order
    */
   void  increaseOrderGoods(Integer goodsId, Order order);

}

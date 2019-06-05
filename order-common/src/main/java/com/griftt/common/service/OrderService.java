package com.griftt.common.service;

import com.griftt.common.entity.Order;
import org.aspectj.weaver.ast.Or;

import java.util.List;

public interface OrderService {

    List<Order> getOrderById(Integer orderId);
}

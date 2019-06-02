package com.griftt.eurekaclient.service;

import com.griftt.eurekaclient.entity.Order;
import org.aspectj.weaver.ast.Or;

import java.util.List;

public interface OrderService {

    List<Order> getOrderById(Integer orderId);
}

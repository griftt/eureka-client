package com.griftt.eurekaclient.service.impl;

import com.griftt.eurekaclient.entity.Order;
import com.griftt.eurekaclient.repository.OrderRepository;
import com.griftt.eurekaclient.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getOrderById(Integer orderId) {
        return orderRepository.findAllById(orderId);
    }
}

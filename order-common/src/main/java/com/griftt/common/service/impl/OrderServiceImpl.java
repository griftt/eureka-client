package com.griftt.common.service.impl;

import com.griftt.common.entity.Order;
import com.griftt.common.repository.OrderRepository;
import com.griftt.common.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getOrderById(Integer orderId) {
        List<Order> allById = orderRepository.findAllById(orderId);
        return allById;
    }
}

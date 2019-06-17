package com.griftt.orderserver.test;

import com.griftt.common.entity.Order;
import com.griftt.common.service.OrderService;
import com.griftt.orderserver.OrderServerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderServerApplication.class)
public class OrderSericeTest {

    @Autowired
    private OrderService orderService;


    @Test
    public void testOrder(){
        List<Order> orderById = orderService.getOrderById(56);
        System.err.println(orderById);
    }
}

package com.griftt.eurekaclient.repository;

import com.griftt.eurekaclient.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface OrderRepository extends JpaRepository<Order,Integer> {

    public List<Order> findAllById(Integer Id);
}

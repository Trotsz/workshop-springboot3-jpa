package com.pursuit.springclass.services;

import com.pursuit.springclass.entities.Order;
import com.pursuit.springclass.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return this.orderRepository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> obj = this.orderRepository.findById(id);
        return obj.isPresent() ? obj.get() : null;
    }
}

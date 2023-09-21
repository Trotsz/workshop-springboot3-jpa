package com.pursuit.springclass.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pursuit.springclass.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}

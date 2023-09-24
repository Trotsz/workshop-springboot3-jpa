package com.pursuit.springclass.repositories;

import com.pursuit.springclass.entities.OrderItem;
import com.pursuit.springclass.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}

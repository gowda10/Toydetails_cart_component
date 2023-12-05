package com.kidzoo.toydetails.repository;

import com.kidzoo.toydetails.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemsRepository extends JpaRepository<OrderItem,Integer> {
}

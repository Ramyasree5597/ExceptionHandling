package com.demo.ExceptionHandling.dao;

import com.demo.ExceptionHandling.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDAO extends JpaRepository<Order, Integer> {
    Order findByName(String name);
}

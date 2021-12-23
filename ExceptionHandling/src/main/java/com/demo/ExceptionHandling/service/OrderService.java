package com.demo.ExceptionHandling.service;

import com.demo.ExceptionHandling.dao.OrderDAO;
import com.demo.ExceptionHandling.exception.OrderServiceException;
import com.demo.ExceptionHandling.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderDAO dao;

@PostConstruct
    public void addOrder2DB(){
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(856,"Mobile","Electronics",6000));
        orders.add(new Order(886,"Bike","Vehicle",10000));
        dao.saveAll(orders);
    }
    public double getPrice(String productName) throws OrderServiceException {
   Order order = null;
    double amount=0;
    try{
   order = dao.findByName(productName);
   amount=order.getAmount();
    }catch(Exception e){
     throw new OrderServiceException("order not found with product: "+productName);
    }
    return amount;

    }
}

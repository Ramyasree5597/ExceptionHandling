package com.demo.ExceptionHandling.controller;

import com.demo.ExceptionHandling.exception.OrderServiceException;
import com.demo.ExceptionHandling.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private OrderService service;
@GetMapping("/getPrice/{productName}")
    public String getOrderPrice(@PathVariable String productName) throws OrderServiceException {
        double amount = service.getPrice(productName);
        return " amount for product " + productName +" is "+amount;
    }
}

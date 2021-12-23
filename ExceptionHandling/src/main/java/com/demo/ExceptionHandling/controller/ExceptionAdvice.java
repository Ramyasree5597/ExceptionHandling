package com.demo.ExceptionHandling.controller;

import com.demo.ExceptionHandling.exception.OrderServiceException;
import com.demo.ExceptionHandling.model.OrderError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(OrderServiceException.class)
    public ResponseEntity<OrderError> mapException(OrderServiceException ex){
        OrderError error = new OrderError(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
        return new ResponseEntity<OrderError>(error, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}

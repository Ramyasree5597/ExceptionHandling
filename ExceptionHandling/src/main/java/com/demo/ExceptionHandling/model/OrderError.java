package com.demo.ExceptionHandling.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

public class OrderError {

    private int errorCode;
    private String errorMessage;
}

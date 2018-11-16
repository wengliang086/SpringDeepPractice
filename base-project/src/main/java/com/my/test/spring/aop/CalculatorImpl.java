package com.my.test.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class CalculatorImpl implements Calculator {
    @Override
    public int add(int i, int j) {
        return i + j;
    }

    @Override
    public int div(int i, int j) {
        return i / j;
    }
}

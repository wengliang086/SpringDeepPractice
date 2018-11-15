package com.my.test.spring.annotation;

import org.springframework.stereotype.Component;

@Component
public class TestObject {

    private int id;
    private boolean b;

    @Override
    public String toString() {
        return "TestObject{" +
                "id=" + id +
                ", b=" + b +
                '}';
    }
}

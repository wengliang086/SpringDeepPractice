package com.my.test.spring.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans-annotation.xml");
        System.out.println(ctx.getBean(TestObject.class));
    }
}

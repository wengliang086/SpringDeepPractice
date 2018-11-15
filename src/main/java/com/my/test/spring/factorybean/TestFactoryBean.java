package com.my.test.spring.factorybean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactoryBean {

    public static void main(String[] args) {
        System.out.println(new ClassPathXmlApplicationContext("beans-factorybean.xml").getBean("car"));
    }
}

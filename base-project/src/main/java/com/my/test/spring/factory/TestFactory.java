package com.my.test.spring.factory;

import com.my.test.spring.base.Car;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactory {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-factory.xml");
        System.out.println(applicationContext.getBean("car1"));
        System.out.println(applicationContext.getBean("car2"));

        applicationContext.getBeansOfType(Car.class).values().forEach(System.out::println);
    }
}

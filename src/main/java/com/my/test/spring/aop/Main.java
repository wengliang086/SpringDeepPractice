package com.my.test.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
//        CalculatorImpl calculator = new CalculatorImpl();
//
//        Calculator proxyCalc = new CalculatorLoggingProxy(calculator).getLoggingProxy();
//
//        System.out.println(calculator.add(1, 2));
//        System.out.println(calculator.div(100, 2));
//
//        System.out.println(proxyCalc.add(1, 2));
//        System.out.println(proxyCalc.div(100, 2));

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans-aop.xml");
        System.out.println(ctx.getBean(Calculator.class).add(2, 5));
        System.out.println(ctx.getBean(Calculator.class).div(12, 5));
    }
}

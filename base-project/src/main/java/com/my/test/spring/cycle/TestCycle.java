package com.my.test.spring.cycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCycle {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("cycleBean.xml");

        System.out.println(classPathXmlApplicationContext.getBean(CycleBean.class));

        classPathXmlApplicationContext.close();
    }
}

package com.my.test.spring.base;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("baseBean.xml");
        // 简单Bean
        Car car1 = (Car) applicationContext.getBean("car1");
        Car car2 = (Car) applicationContext.getBean("car2");
        System.out.println(car1);
        System.out.println(car2);
        System.out.println(applicationContext.getBean("car3"));
        // 带引用Bean
        Persion persion = applicationContext.getBean(Persion.class);
        System.out.println(persion);
        // 集合属性
        Persion2 persion2 = (Persion2) applicationContext.getBean("persion2");
        System.out.println(persion2);
        System.out.println(applicationContext.getBean("persion22"));
        Persion3 persion3 = applicationContext.getBean(Persion3.class);
        System.out.println(persion3);
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        System.out.println(dataSource);
    }
}

package com.my.test.spring.base;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAutowire {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("autowireBean.xml");
//        System.out.println(applicationContext.getBean("persion"));// BeanIsAbstractException
        System.out.println(applicationContext.getBean("persion1"));
        System.out.println(applicationContext.getBean("persion2"));
        System.out.println(applicationContext.getBean("persion3"));
    }
}

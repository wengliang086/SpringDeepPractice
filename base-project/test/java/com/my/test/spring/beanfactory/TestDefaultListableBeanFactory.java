package com.my.test.spring.beanfactory;

import com.my.test.spring.base.Car;
import com.my.test.spring.factorybean.CarFactoryBean;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

public class TestDefaultListableBeanFactory {

    @Test
    public void test() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClass(Car.class);
        beanFactory.registerBeanDefinition("name1", beanDefinition);

        beanFactory.registerBeanDefinition("name2", new RootBeanDefinition(CarFactoryBean.class));

        Car car = (Car) beanFactory.getBean("name1");
        System.out.println(car);
        System.out.println(beanFactory.getBean("name2"));
        System.out.println(beanFactory.getBean("&name2"));
    }
}

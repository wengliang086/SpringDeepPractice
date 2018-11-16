package com.my.test.spring.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 因为 后置处理器是用来处理所有Bean的，所以一般需要在里面加条件判断
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization: " + bean + ", " + beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization: " + bean + ", " + beanName);
        if (bean instanceof CycleBean) {
            ((CycleBean) bean).setId("偷梁换柱");
        }
        return bean;
    }
}

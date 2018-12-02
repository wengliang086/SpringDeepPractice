package com.my.test.spring.annotation.config;

import com.my.test.spring.aop.Calculator;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainConfigOfAOPTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
        Calculator calculator = applicationContext.getBean(Calculator.class);
        System.out.println(calculator.add(3, 9));
        int div = calculator.div(100, 0);
        System.out.println(div);
        applicationContext.close();
    }

}

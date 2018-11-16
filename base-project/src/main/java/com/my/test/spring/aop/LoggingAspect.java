package com.my.test.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(* com.my.test.spring.aop.Calculator.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("before..." + methodName + " begin with " + args);
    }

    // 后置通知：在目标方法执行后（无论是否发生异常）
    // 不能访问目标方法的执行结果，需要在返回通知中
    @After("execution(* com.my.test.spring.aop.Calculator.*(..))")
    public void endMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("end..." + methodName);
    }
}

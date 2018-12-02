package com.my.test.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Aspect
public class LoggingAspect {

    @Pointcut("execution(* com.my.test.spring.aop.Calculator.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("---Aspect before ..." + methodName + " begin with " + args);
    }

    // 后置通知：在目标方法执行后（无论是否发生异常）
    // 不能访问目标方法的执行结果，需要在返回通知中
    @After("pointCut()")
    public void endMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("---Aspect end ..." + methodName);
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void returnMethod(Object result) {
        System.out.println("---Aspect return ... {" + result + "}");
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void exceptionMethod(JoinPoint joinPoint, Exception exception) {
        System.out.println("---Aspect exception ... {" + joinPoint.getSignature().getName() + "}{" + exception.getMessage() + "}");
    }
}

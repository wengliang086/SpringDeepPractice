package com.my.test.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class CalculatorLoggingProxy {

    private Calculator target;

    public CalculatorLoggingProxy(Calculator target) {
        this.target = target;
    }

    public Calculator getLoggingProxy() {
        Calculator proxy = null;
        ClassLoader loader = target.getClass().getClassLoader();

        InvocationHandler invocationHandler = new InvocationHandler() {

            /**
             *
             * @param proxy 正在返回的那个代理对象，一般情况下，在invoke方法中都不使用该对象
             * @param method 正在被执行的方法
             * @param args 上面方法的参数
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                System.out.println("The method " + methodName + " begins with " + Arrays.asList(args));
                Object result = method.invoke(target, args);
                System.out.println("The method " + methodName + " ends with " + result);
                return result;
            }
        };
        proxy = (Calculator) Proxy.newProxyInstance(loader, new Class[]{Calculator.class}, invocationHandler);
        return proxy;
    }
}

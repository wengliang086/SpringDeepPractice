package com.my.test.spring.factory;

import com.my.test.spring.base.Car;

import java.util.HashMap;
import java.util.Map;

/**
 * 静态工厂方法
 */
public class StaticCarFactory {

    private static Map<String, Car> cars = new HashMap<String, Car>();

    static {
        cars.put("audi", new Car("audi", "shanghai", 308888d));
        cars.put("ford", new Car("ford", "changan", 108888d));
    }

    public static Car getCar(String name) {
        return cars.get(name);
    }
}

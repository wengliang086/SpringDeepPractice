package com.my.test.spring.factory;

import com.my.test.spring.base.Car;

import java.util.HashMap;
import java.util.Map;

/**
 * 实例的工厂方法，工厂是需要先去创建的
 */
public class InstanceCarFactory {

    private Map<String, Car> cars = null;

    public InstanceCarFactory() {
        cars = new HashMap<String, Car>();
        cars.put("audi", new Car("audi", "shanghai", 308888d));
        cars.put("ford", new Car("ford", "changan", 108888d));
    }

    public Car getCar(String name) {
        return cars.get(name);
    }
}

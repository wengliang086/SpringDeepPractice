package com.my.test.spring.base;

import java.util.Map;

public class Persion3 {

    private String name;

    public Map<String, Car> getCars() {
        return cars;
    }

    public void setCars(Map<String, Car> cars) {
        this.cars = cars;
    }

    private Map<String, Car> cars;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Persion2{" +
                "name='" + name + '\'' +
                ", cars=" + cars +
                '}';
    }
}

package com.my.test.spring.base;

public class Persion {

    private String name;
    private Car car;

    public Persion() {
    }

    public Persion(String name, Car car) {
        this.name = name;
        this.car = car;
    }

    @Override
    public String toString() {
        return "Persion{" +
                "name='" + name + '\'' +
                ", car=" + car +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}

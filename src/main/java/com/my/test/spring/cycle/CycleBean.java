package com.my.test.spring.cycle;

public class CycleBean {

    private String id;

    public CycleBean() {
        System.out.println("construct");
    }

    public void init() {
        System.out.println("init method");
    }

    public void destroy() {
        System.out.println("destroy method");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        System.out.println("set value");
        this.id = id;
    }

    @Override
    public String toString() {
        return "CycleBean{" +
                "id='" + id + '\'' +
                '}';
    }
}

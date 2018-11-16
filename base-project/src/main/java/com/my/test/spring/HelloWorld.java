package com.my.test.spring;

import java.util.Properties;

public class HelloWorld {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("zhansan", "aa");
        properties.put("lisi", "bb");
        System.out.println(properties);
    }

}

package com.my.test.spring.tx;

public interface BookShopDao {

    int getBookPriceById(String id);

    void updateBookStore(String id);

    void updateUserBalance(String userId, int price);
}

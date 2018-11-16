package com.my.test.spring.tx;

import java.util.List;

public interface BookShopService {

    void buyBook(String userId, String bookId);

    void buyBooks(String userId, List<String> bookIds);
}

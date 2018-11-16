package com.my.test.spring.tx;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookShopServiceImpl implements BookShopService {

    @Resource
    private BookShopDao bookShopDao;

    @Transactional
    @Override
    public void buyBook(String userId, String bookId) {
        int price = bookShopDao.getBookPriceById(bookId);
        bookShopDao.updateBookStore(bookId);
        bookShopDao.updateUserBalance(userId, price);
    }

    @Transactional(
            propagation = Propagation.REQUIRED,// 事务的传播性
            isolation = Isolation.READ_COMMITTED,// 事务的隔离性
            timeout = 2,
            readOnly = false
    )
    @Override
    public void buyBooks(String userId, List<String> bookIds) {
        bookIds.forEach(bookId -> buyBook(userId, bookId));
    }
}

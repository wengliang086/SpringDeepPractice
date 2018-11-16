package com.my.test.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookShopDaoImpl implements BookShopDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int getBookPriceById(String id) {
        return jdbcTemplate.queryForObject("select password from users where id = ?", Integer.class, id);
    }

    @Override
    public void updateBookStore(String id) {

    }

    @Override
    public void updateUserBalance(String userId, int price) {

    }
}

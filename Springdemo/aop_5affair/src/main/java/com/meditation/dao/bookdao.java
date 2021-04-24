package com.meditation.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: Andy
 */
@Repository
public class bookdao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    // 减余额
    public void updatebalance(String userName, int price) {
        String sql = "UPDATE account SET balance=balance-? WHERE username = ?";
        jdbcTemplate.update(sql, price, userName);

    }
    // 获取图书的价格
    public int getprice(String isbn) {
        String sql = "SELECT price FROM book WHERE isbn = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, isbn);
    }

    // 减库存
    public void updatestock(String isbn) {
        String sql = "UPDATE book_stock SET stock = stock - 1 WHERE isbn = ?";
        jdbcTemplate.update(sql, isbn);
    }
    //修改图书的价格
    public void updateBookprice(String isbn,double price){
        String sql = "UPDATE book SET price = ? WHERE isbn = ?";
        jdbcTemplate.update(sql,price,isbn);
    }
}

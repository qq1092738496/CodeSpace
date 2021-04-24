package com.meditation.pojo;

/**
 * @description:
 * @author: Andy
 * @time: 2020/7/10 23:08
 */
public class book {
    private String isbn;
    private int stock;

    public book() {
    }

    public book(String isbn, int stock) {
        this.isbn = isbn;
        this.stock = stock;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "book{" + "isbn='" + isbn + '\'' + ", stock=" + stock + '}';
    }
}

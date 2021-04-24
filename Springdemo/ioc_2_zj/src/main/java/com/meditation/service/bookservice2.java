package com.meditation.service;

import com.meditation.dao.bookdao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class bookservice2 {
    @Autowired(required = false)
    private bookdao bookdao;

    public void seave() {
        System.out.println("图书正在被装配aaaaaaa");
        bookdao.seave();
    }
}

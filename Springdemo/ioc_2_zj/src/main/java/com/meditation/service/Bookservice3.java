package com.meditation.service;

import com.meditation.dao.bookdao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Bookservice3 {

    @Resource
    private bookdao bookdao;

    public void seave() {
        System.out.println("图书正在被装配");
        bookdao.seave();
    }
}

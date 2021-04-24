package com.meditation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @author: Andy
 * @time: 2020/7/13 4:42
 */

@Service
public class spread {

    @Autowired
    checkout checkout;

    @Transactional
    public void Nested(){
        checkout.payments("张三","ISBN-001");
        checkout.modifybookbalance("ISBN-001",20);
    }
}

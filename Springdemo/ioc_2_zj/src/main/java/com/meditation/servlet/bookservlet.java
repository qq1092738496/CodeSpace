package com.meditation.servlet;

import com.meditation.service.Bookservice3;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class bookservlet {

    @Resource
    private Bookservice3 bookservice3;

    public void servlet() {
        bookservice3.seave();
    }
}

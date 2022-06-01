package com.guanzizai.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Andy
 * @time: 2021/6/27 21:51
 */

@RestController
public class shipinController{

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        
        return "aaaaaa";
    };

}

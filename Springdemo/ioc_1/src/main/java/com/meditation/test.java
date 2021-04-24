package com.meditation;


import com.meditation.pojo.user;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc_1.xml");
        user user = (user) context.getBean("user");
        System.out.println(user);
    }
}

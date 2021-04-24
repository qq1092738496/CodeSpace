package com.meditation.Test;

import com.meditation.pojo.user;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class test {

    @Test
    public void test1() {
        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext2.xml");
            user bean = context.getBean(user.class);
            System.out.println(bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

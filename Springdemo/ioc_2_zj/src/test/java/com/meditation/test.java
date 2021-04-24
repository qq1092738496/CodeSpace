package com.meditation;

import com.meditation.servlet.bookservlet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ProjectName: Springdemo
 * @Package: com.meditation
 * @ClassName: test
 * @Author: yf
 * @Description: ${description}
 * @Date: 2020/7/2 21:59
 */

/**
 * 使用Spring单元测试:;
 * 1. 导包:Spring单元测试包Spring-test-4.0.0.RELEASE.jat;
 * 2.@ContextConfiguration(locations="")指定Spring指定配置文件位置;
 * 3.@Runwith指定用那种驱动单元测试,默认是junit;
 *
 * @RunWith(SpringJUnit4ClassRunner.class); 使用Spring的单元测试模块来执行 @Test注解的测试方法;
 * 以前的@Test 是由junit来执行的;
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationtext01.xml")
public class test {

    /**
     * 使用注解加入到容器的组件,和使用配置加入到容器中的组件都是默认一样
     * 1.组件的id默认为首字母小写,修改id名字;
     *
     * @Repository("bookdaohaha") public class bookdao {
     * 2.组件的作用域,默认为单例,修改为多例;
     * @Scope(value = "prototype")
     * public class bookdao {
     */
    ApplicationContext context = null;
    @Autowired
    bookservlet bookservlet;

    @Test
    public void test1() {
        bookservlet.servlet();
      /*  ApplicationContext context = new ClassPathXmlApplicationContext("applicationtext01.xml");
        bookservlet bean1 = (bookservlet) context.getBean("bookservlet");
        bean1.servlet();*/
    }

}

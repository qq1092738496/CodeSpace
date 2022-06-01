package com.xad.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @description:
 * @author: Andy
 * @time: 2022/5/4 19:02
 */

public class DButil {
    public static SqlSession getsqlSession(){
        InputStream resourceInput = null;
        try {
            resourceInput = Resources.getResourceAsStream("mapper.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceInput);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }
}

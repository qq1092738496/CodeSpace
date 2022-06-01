package com.xad.service.serviceImpl;

import com.xad.mapper.fabulousMapper;
import com.xad.mapper.newsMapper;
import com.xad.mapper.userMapper;
import com.xad.pojo.Fabulous;
import com.xad.pojo.News;
import com.xad.pojo.NewsPage;
import com.xad.pojo.User;
import com.xad.pojo.UserPage;
import com.xad.service.Display_Data;
import com.xad.util.DButil;
import org.apache.ibatis.session.SqlSession;

import java.util.LinkedList;

/**
 * @description:
 * @author: Andy
 * @time: 2022/5/5 10:43
 */

public class Display_DataImpl implements Display_Data {
    /* //用户个人信息
     @Override
     public void User_Information() {
         SqlSession sqlSession = DButil.getsqlSession();
         userMapper userMapper = sqlSession.getMapper(userMapper.class);
         userMapper.getUser();
     }*/
    //所有用户信息
    SqlSession sqlSession = DButil.getsqlSession();
    @Override
    public UserPage All_User_Information(String userName, int indexes, int showdata) {

        userMapper userMapper = sqlSession.getMapper(userMapper.class);

        LinkedList<User> listUser = userMapper.getUser_limit(userName,(indexes-1)*showdata, showdata);
        UserPage userPage = new UserPage();
        userPage.setLimitUser(listUser);
        userPage.setThisPage(indexes);
        userPage.setPageSize(showdata);
        userPage.setTotalUser(userMapper.getUserCount()-1);
        sqlSession.close();
        return userPage;
    }

    //展示该用户所有消息
    @Override
    public NewsPage All_User_News(String newsNumber, Integer indexes,
                                          Integer showdata) {

        newsMapper newsMapper = sqlSession.getMapper(newsMapper.class);
        LinkedList<News> news_number = newsMapper.getNews_limit(newsNumber, (indexes-1)*showdata, showdata);
        NewsPage newsPage = new NewsPage();
        newsPage.setLimitNews(news_number);
        newsPage.setThisPage(indexes);
        newsPage.setPageSize(showdata);
        newsPage.setTotalNews(newsMapper.getNewsCount(newsNumber));
        sqlSession.close();
        return newsPage;
    }

    //查询newsNumber的所有点赞数
    @Override
    public Fabulous query_Fabulous(String newsNumber, String Sort_Id) {

        fabulousMapper fabulousmapper = sqlSession.getMapper(fabulousMapper.class);
        Fabulous fabulous = fabulousmapper.User_Fabulous(newsNumber, Sort_Id);
        return fabulous;
    }
}

package com.xad.service.serviceImpl;

import com.xad.mapper.fabulousMapper;
import com.xad.mapper.newsMapper;
import com.xad.mapper.userMapper;
import com.xad.pojo.Fabulous;
import com.xad.pojo.News;
import com.xad.pojo.User;
import com.xad.pojo.UserPage;
import com.xad.service.User_Function;
import com.xad.util.DButil;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @description:
 * @author: Andy
 * @time: 2022/5/4 17:39
 */

public class User_functionImpl implements User_Function {
    SqlSession sqlSession = DButil.getsqlSession();
    //注册
    @Override
    public int Register(User user) {
        userMapper userMapper = sqlSession.getMapper(userMapper.class);
        User users = userMapper.getUser(user.getUserName());
        if (users == null) {
            if (user.getUserName().length() >= 4 && user.getPassWord().length() >= 4) {
                userMapper.insert(user);
                sqlSession.commit();
                return 1;
            } else if (users != null) {
                return 2;
            }
        }
        sqlSession.close();
        return 0;
    }

    //登入
    @Override
    public int Login(String userName, String passWord) {
        userMapper userMapper = sqlSession.getMapper(userMapper.class);
        User user = userMapper.getUser(userName);
        if (null != user) {
            if (user.getPassWord().equals(passWord)) {
                return 1;
            }
        }
        sqlSession.close();
        return 0;
    }

    //获取个人信息
    @Override
    public User User_Information(String userName) {
        userMapper userMapper = sqlSession.getMapper(userMapper.class);
        User user = userMapper.getUser(userName);
        sqlSession.close();
        return user;
    }

    //获取个人消息
    public LinkedList<News> News_Information(String userNumber) {
        SqlSession sqlSession = DButil.getsqlSession();
        newsMapper newsMapper = sqlSession.getMapper(newsMapper.class);
        LinkedList<News> news_number = newsMapper.getNews_Number(userNumber);
        return news_number;
    }

    //找回密码
    @Override
    public int Retrieve_passWord(HashMap<String, String> userMap) {
        userMapper userMapper = sqlSession.getMapper(userMapper.class);

        User user = userMapper.getUser(userMap.get("userName"));
        if (user != null & user.getMailbox().equals(userMap.get("Mailbox"))) {
            if (userMap.get("passWord").length() >= 6) {
                user.setPassWord(userMap.get("passWord"));
                userMapper.update(user);
                sqlSession.commit();
                return 1;
            }
        }
        sqlSession.close();
        return 0;
    }

    //发送消息
    @Override
    public int User_News(News news) {
        newsMapper newsMapper = sqlSession.getMapper(newsMapper.class);
        LinkedList<News> news_number = newsMapper.getNews_Number(news.getnewsNumber());
        news.setSort_Id(news_number.size() + 1);
        int insert = newsMapper.insert(news);
        sqlSession.commit();
        if (insert == 1) {
            return 1;
        }
        sqlSession.close();
        return 0;
    }

    //删除消息
    @Override
    public int delet_News(String Number, int Sort_id) {
        newsMapper newsMapper = sqlSession.getMapper(newsMapper.class);
        int delete = newsMapper.delete(Number, Sort_id);
            sqlSession.commit();
            sqlSession.close();
        if (delete == 1) {
            return delete;
        }
        return 0;
    }

    //点赞
    @Override
    public int User_Fabulous(Fabulous fabulous) {
        fabulousMapper fabulousMapper = sqlSession.getMapper(fabulousMapper.class);
        Fabulous user_fabulous = fabulousMapper.User_Fabulous(fabulous.getFabulous_Number(),
                Integer.valueOf(fabulous.getSort_Id()).toString());
        if (user_fabulous == null) {
            fabulousMapper.insert(fabulous);
            sqlSession.commit();
            return 1;
        } else if (user_fabulous != null) {
            fabulousMapper.delete(fabulous.getFabulous_Number(), Integer.valueOf(fabulous.getSort_Id()).toString());
            sqlSession.commit();
            return 0;
        }
        sqlSession.close();

        return 0;
    }

    //搜索
    @Override
    public UserPage likeUser(String userName, int indexes, int showdata) {
        userMapper userMapper = sqlSession.getMapper(userMapper.class);
        LinkedList<User> users = userMapper.likeUser(userName, (indexes - 1) * showdata, showdata);
        UserPage userPage = new UserPage();
        userPage.setLimitUser(users);
        userPage.setThisPage(indexes);
        userPage.setPageSize(showdata);
        userPage.setTotalUser(userMapper.likeUserCount(userName, (indexes - 1) * showdata, showdata));
        sqlSession.close();
        return userPage;
    }


}

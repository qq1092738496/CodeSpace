package com.xad.service;

import com.xad.pojo.Fabulous;
import com.xad.pojo.News;
import com.xad.pojo.User;
import com.xad.pojo.UserPage;
import com.xad.util.DButil;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @description:
 * @author: Andy
 * @time: 2022/5/4 17:37
 */
public interface User_Function {
    //注册
    int Register(User user);
    //登入
    int Login(String userName,String password);
    //用户个人信息
     User User_Information(String userName);
     //用户个人消息
     LinkedList<News> News_Information(String userNumber);
    //通过邮箱,找回密码
    int Retrieve_passWord(HashMap<String,String> userMap);
    //发送消息
    int User_News(News news);
    int delet_News(String Number,int Sort_id);
    //点赞
    int User_Fabulous(Fabulous fabulous);
    //搜索
    UserPage likeUser(String userName, int indexes, int showdata);
}

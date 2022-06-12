package service;

import pojo.user;

import java.util.HashMap;

/**
 * @description:
 * @author: Andy
 * @time: 2022/6/11 13:44
 */
public interface business {
    //登入
    int Login(String userName,String password);
    //通过邮箱,找回密码
    int Retrieve_passWord(String userName,String mailbox,String password);
    //注册
    int Register(String userName,String mailbox,String password);
    //注销
    int cancellation(String userName,String mailbox,String password);

}

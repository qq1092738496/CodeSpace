package service;

import dao.userDao;
import dao.userDaoImpl;
import pojo.user;

/**
 * @description:
 * @author: Andy
 * @time: 2022/6/11 13:59
 */

public class businessImpl implements business {
    userDao userDao = new userDaoImpl();

    
    //登入
    @Override
    public int Login(String userName, String password) {
        user user = userDao.getuser(userName);
        if (null != user.getUserName()) {
            if (user.getPassWord().equals(password)) {
                return 1;
            }
        }
        return 0;
    }

    //找回密码
    @Override
    public int Retrieve_passWord(String userName, String password, String mailbox) {
        user user = userDao.getuser(userName);
        if (user.getUserName() != null & user.getMailbox().equals(mailbox)) {
            user.setPassWord(password);
            userDao.update(user);
            
            return 1;
        }
        return 0;
    }

    //注册
    @Override
    public int Register(String userName,  String password,String mailbox) {
        user users = userDao.getuser(userName);
        if (users.getUserName() == null) {
            user user = new user();
            user.setUserName(userName);
            user.setPassWord(password);
            user.setMailbox(mailbox);
            userDao.add(user);
            return 1;

        }
        return 0;
    }
    
    //注销
    @Override
    public int cancellation(String userName, String password) {
        user users = userDao.getuser(userName);
        if (users.getUserName() != null & users.getPassWord().equals(password)) {
            user user = new user();
            
            user.setUserName(userName);
            user.setPassWord(password);
            userDao.delete(userName);
            return 1;
        }
        return 0;
    }
}

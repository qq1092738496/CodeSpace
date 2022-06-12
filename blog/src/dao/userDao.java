package dao;

import pojo.user;

import java.util.LinkedList;

/**
 * @description:
 * @author: Andy
 * @time: 2022/6/11 12:42
 */
public interface userDao {
    void add(user user);
    void delete(String userName);
    void update(user user);
    LinkedList<user> AllUser();
    user getuser(String userNmae);
}

package com.xad.mapper;


import com.xad.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @description:
 * @author: Andy
 * @time: 2022/5/3 12:51
 */
public interface userMapper {
    ArrayList<User> select();
    int insert(User user);
    int delete(@Param("userNumber") String userNumber);
    int update(User user);
    User getUser(@Param("userName") String userName);
    LinkedList<User> getUser_limit(@Param("userName") String userName ,@Param("indexes") int indexes,
                                   @Param("showdata") int showdata);
    int getUserCount();

    LinkedList<User> likeUser(@Param("userName") String userName,@Param("indexes") int indexes,
                              @Param("showdata") int showdata);
    int likeUserCount(@Param("userName") String userName,@Param("indexes") int indexes,
                      @Param("showdata") int showdata);

}

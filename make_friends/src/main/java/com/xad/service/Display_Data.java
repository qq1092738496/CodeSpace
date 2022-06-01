package com.xad.service;

import com.xad.pojo.Fabulous;
import com.xad.pojo.News;
import com.xad.pojo.NewsPage;
import com.xad.pojo.User;
import com.xad.pojo.UserPage;

import java.util.LinkedList;

/**
 * @description:
 * @author: Andy
 * @time: 2022/5/5 10:21
 */
public interface Display_Data {
    //所有用户信息
    public UserPage All_User_Information(String userName, int indexes, int showdata);

    //所有用户消息
    public NewsPage All_User_News(String newsNumber, Integer indexes,
                                  Integer showdata);

    //根据number查询点赞数
    public Fabulous query_Fabulous(String newsNumber, String Sort_Id);

}

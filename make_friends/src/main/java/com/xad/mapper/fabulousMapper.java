package com.xad.mapper;

import com.xad.pojo.Fabulous;
import com.xad.pojo.News;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @description:
 * @author: Andy
 * @time: 2022/5/3 12:52
 */
public interface fabulousMapper {
    ArrayList<Fabulous> select();
    int insert(Fabulous fabulous);
    int delete(@Param("Fabulous_Number") String Fabulous_Number,@Param("Sort_Id") String Sort_Id);
    int update(Fabulous fabulous);

    //点赞
    Fabulous User_Fabulous(@Param("Fabulous_Number") String Fabulous_Number,@Param("Sort_Id") String Sort_Id);
}

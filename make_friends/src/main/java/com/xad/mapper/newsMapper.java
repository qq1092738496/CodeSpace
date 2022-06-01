package com.xad.mapper;

import com.xad.pojo.News;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @description:
 * @author: Andy
 * @time: 2022/5/3 12:52
 */
public interface newsMapper {

    int insert(News news);

    int delete(@Param("newsNumber") String newsNumber,@Param("Sort_Id") int Sort_Id);

    int update(News news);

    LinkedList<News> getNews_Number(@Param("newsNumber") String newsNumber);

    LinkedList<News> getNews_limit(@Param("newsNumber") String newsNumber, @Param("indexes") Integer indexes,
                                   @Param("showdata") Integer showdata);
    int getNewsCount(@Param("newsNumber") String newsNumber);

}

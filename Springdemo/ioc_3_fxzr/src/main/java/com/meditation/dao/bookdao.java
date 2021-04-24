package com.meditation.dao;

import com.meditation.pojo.book;
import org.springframework.stereotype.Repository;

/**
 * @ProjectName: Springdemo
 * @Package: com.meditation.dao
 * @ClassName: bookdao
 * @Author: yf
 * @Description: ${description}
 * @Date: 2020/7/3 17:39
 */
@Repository
public class bookdao extends basedao<book> {

    @Override
    public void save() {
        System.out.println("bookdao存入数据库");
    }

}

package com.meditation.dao;

import com.meditation.pojo.user;
import org.springframework.stereotype.Repository;

/**
 * @ProjectName: Springdemo
 * @Package: com.meditation.dao
 * @ClassName: userdao
 * @Author: yf
 * @Description: ${description}
 * @Date: 2020/7/3 17:40
 */
@Repository
public class userdao extends basedao<user> {

    @Override
    public void save() {
        System.out.println("userdao存入数据库");
    }

}

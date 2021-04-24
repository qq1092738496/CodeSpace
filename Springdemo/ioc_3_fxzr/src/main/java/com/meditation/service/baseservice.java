package com.meditation.service;

import com.meditation.dao.basedao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ProjectName: Springdemo
 * @Package: com.meditation.service
 * @ClassName: baseservice
 * @Author: yf
 * @Description: ${description}
 * @Date: 2020/7/4 0:55
 */

public class baseservice<T> {
    @Autowired
    basedao<T> basedao;

    public void save() {
        basedao.save();
    }
}

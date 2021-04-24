package com.meditation.util;

import com.meditation.dao.impl.modifyimpl;
import com.meditation.dao.modify;
import com.meditation.pojo.message;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

public class mypipeline58 implements Pipeline {

    @Override
    public void process(ResultItems resultItems, Task task) {

        String url = resultItems.get("url").toString();
        String title = resultItems.get("标题").toString();
        String companyName = resultItems.get("公司名字").toString();
        String companymessage = resultItems.get("公司信息").toString();
        String education = resultItems.get("学历").toString();
        String time = resultItems.get("发布日期").toString();
        String site = resultItems.get("上班地址").toString();
        String money = resultItems.get("工资").toString();
        String workmessage = resultItems.get("工作信息").toString();
        String source = resultItems.get("source").toString();
        message message = new message(title, companyName, companymessage, education, time, site, money, workmessage, url,source);


        modify modify = new modifyimpl();
        Integer insert = modify.Insert(message);
        if (insert == 1){
            System.out.println("url:"+url+"已插入数据库");
        }else if(insert == 0){
            System.out.println("url:"+url+"插入失败");
        }
    }
}

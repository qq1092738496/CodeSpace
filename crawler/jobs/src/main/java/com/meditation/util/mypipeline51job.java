package com.meditation.util;

import com.meditation.dao.impl.modifyimpl;
import com.meditation.dao.modify;
import com.meditation.pojo.message;
import net.htmlparser.jericho.Source;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

public class mypipeline51job implements Pipeline {

    @Override
    public void process(ResultItems resultItems, Task task) {
        String title = resultItems.get("标题").toString();
        String companyName = resultItems.get("公司名字").toString();
        String companymessage = resultItems.get("公司信息").toString();
        String education = null; //学历
        Object[] s3 = resultItems.get("公司需求");
        for (Object s4 : s3) {
            String[] split = s4.toString().split("\\D\\D\\|\\D\\D");
            for (String s5 : split) {
                if (s5.equals("初中及以下") || s5.equals("高中") || s5.equals("中技") || s5.equals("中专") || s5.equals("大专") || s5.equals("专科") || s5.equals("本科") || s5.equals("硕士") || s5.equals("博士")) {
                    education = s5;
                }
            }
        }
        String time = resultItems.get("发布日期").toString();
        String site = resultItems.get("上班地址").toString();
        String s5 = resultItems.get("工资").toString();
        String[] split = s5.split("\\D/\\D");
        String money = split[0]; //工资
        List<String> s6 = resultItems.get("工作信息");
        String workmessage = null; //工作信息
        for (String ww : s6) {
            Source source = new Source(ww);
            workmessage = source.getTextExtractor().toString().trim();
        }
        String url = resultItems.get("util").toString();

        String source = resultItems.get("source");
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

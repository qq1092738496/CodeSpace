package com.meditation.service;

import com.meditation.util.mypipeline51job;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

public class analysis51job implements PageProcessor{
    @Override
    public void process(Page page) {
      /*  page.addTargetRequests(page.getHtml()
                .xpath("/html/body/div[2]/div[3]/div/div[2]/div[4]/div[1]/div[1]/a/p[1]/span")
                .links().all());*/

        String s =
                page.getHtml().xpath("/html/body/div/div[@class=\"j_result\"]").get();



       /* page.putField("util", page.getUrl());
        page.putField("标题", page.getHtml().xpath("/html/body/div[3]/div[2]/div[2]/div/div[1]/h1/@title"));
        page.putField("公司名字", page.getHtml().xpath("/html/body/div[3]/div[2]/div[2]/div/div[1]/p[1]/a[1]/@title"));
        page.putField("公司信息", page.getHtml().xpath("/html/body/div[3]/div[2]/div[4]/div[1]/div[2]/p/@title").all());
        page.putField("公司需求", page.getHtml().xpath("/html/body/div[3]/div[2]/div[2]/div/div[1]/p[2]/@title").all().toArray());
        page.putField("发布日期", page.getHtml().xpath("/html/body/div[3]/div[2]/div[2]/div/div[1]/p[2]/@title").regex("\\d\\d-\\d\\d").get());
        page.putField("上班地址", page.getHtml().xpath("/html/body/div[3]/div[2]/div[3]/div[2]/div/p/text()"));
        page.putField("工资", page.getHtml().xpath("/html/body/div[3]/div[2]/div[2]/div/div[1]/strong/text()"));
        List<String> all1 = page.getHtml().xpath("/html/body/div[3]/div[2]/div[3]/div[1]/div[@class=\"bmsg job_msg inbox\"]").all();

        page.putField("工作信息", all1);
        page.putField("source","51job");

        if (page.getResultItems().get("标题") == null
                || page.getResultItems().get("公司名字") == null
                || page.getResultItems().get("公司信息") == null
                || page.getResultItems().get("公司信息") == null
                || page.getResultItems().get("公司需求") == null
                || page.getResultItems().get("工资") == null
                || page.getResultItems().get("工作信息") == null
        ) {
            page.setSkip(true);
        }*/
    }
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setUserAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.97 Safari/537.36");
    @Override
    public Site getSite() {
        return site;
    }


}

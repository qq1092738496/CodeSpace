package com.meditation.service;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

public class analysis58 implements PageProcessor{
    @Override
    public void process(Page page) {
        page.addTargetRequests(page.getHtml().xpath("//*[@id=\"list_con\"]/li").links().all());


        page.putField("url",page.getUrl());
        page.putField("标题",page.getHtml().xpath("/html/body/div[3]/div[3]/div[1]/div[2]/span[1]/text()").toString());
        page.putField("公司名字",page.getHtml().xpath("/html/body/div[3]/div[4]/div[1]/div/div[1]/div[1]/a/text()").toString());
        page.putField("公司信息",page.getHtml().xpath("/html/body/div[3]/div[4]/div[1]/div/p[1]/a/text()").toString());
        page.putField("学历",page.getHtml().xpath("/html/body/div[3]/div[3]/div[1]/div[4]/span[2]/text()").toString());
        String data = page.getHtml().xpath("/html/body/div[3]/div[3]/div[1]/div[1]/span[1]/span/strong/text()").toString();
        if (data != null){
            String s = data + page.getHtml().xpath("/html/body/div[3]/div[3]/div[1]/div[1]/span[1]/span/text()").toString();
            page.putField("发布日期",s);
        }else if(data == null){
            page.putField("发布日期",page.getHtml().xpath("/html/body/div[3]/div[3]/div[1]/div[1]/span[1]/span/text()").toString());
        }
        page.putField("上班地址",page.getHtml().xpath("/html/body/div[3]/div[3]/div[1]/div[5]/span[2]/text()").toString());
        page.putField("工资",page.getHtml().xpath("/html/body/div[3]/div[3]/div[1]/div[2]/span[2]/text()").toString());
        page.putField("工作信息",page.getHtml().xpath("/html/body/div[3]/div[3]/div[2]/div[1]/div[1]/div[@class=\"des\"]/text()").toString());
        page.putField("source","58同城");
        if (page.getResultItems().get("标题") == null
                || page.getResultItems().get("公司名字") == null
                || page.getResultItems().get("公司信息") == null
                || page.getResultItems().get("学历") == null
                || page.getResultItems().get("发布日期") == null
                || page.getResultItems().get("工资") == null
                || page.getResultItems().get("上班地址") == null
                || page.getResultItems().get("工作信息") == null
        ) {
            page.setSkip(true);
        }
    }
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setUserAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.97 Safari/537.36");
    @Override
    public Site getSite() {
        return site;
    }
}

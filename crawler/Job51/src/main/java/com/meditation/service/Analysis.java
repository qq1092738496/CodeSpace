package com.meditation.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @description:
 * @author: Andy
 * @time: 2020/10/22 1:40
 */

public class Analysis implements PageProcessor {

    @Override
    public void process(Page page) {
        System.out.println(page.getHtml());
    }

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setUserAgent("Mozilla/5.0 (Windows NT 6.1; " +
                                                                                            "Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.97 Safari/537.36");
    @Override
    public Site getSite() {
        return site;
    }
}

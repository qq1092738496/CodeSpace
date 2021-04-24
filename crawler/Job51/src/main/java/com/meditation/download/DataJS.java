package com.meditation.download;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.downloader.Downloader;
import us.codecraft.webmagic.selector.Html;

import java.io.IOException;

/**
 * @description:
 * @author: Andy
 * @time: 2020/10/22 2:15
 */

public class DataJS implements Downloader {
    @Override
    public Page download(Request request, Task task) {

        String url = request.getUrl();
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(request.getUrl());
        Site site = task.getSite();

        httpGet.setHeader("UserAgent", site.getUserAgent());
        Html html = null;
        try {
            CloseableHttpResponse execute = client.execute(httpGet);
            HttpEntity entity = execute.getEntity();
            String strings = EntityUtils.toString(entity, "utf-8");
            html = new Html(strings);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Page page = new Page();
        page.setHtml(html);

        return page;
    }

    @Override
    public void setThread(int threadNum) {

    }
}

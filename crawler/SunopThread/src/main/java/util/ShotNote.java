package util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Andy
 * @time: 2020/10/26 0:05
 */

public class ShotNote {
    CloseableHttpClient client = HttpClients.createDefault();
    HttpGet httpGet = new HttpGet();

    {
        httpGet.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        httpGet.setHeader("Connection", "keep-alive");
        httpGet.setHeader("Content-Type", "text/html; charset=UTF-8");
        httpGet.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp," +
                "image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        httpGet.setHeader("Accept-Encoding", "gzip, deflate, br");
        httpGet.setHeader("Accept-Language", "zh-CN,zh;q=0.9");
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like " +
                "Gecko) Chrome/85.0.4183.121 Safari/537.36");
        httpGet.setHeader("Host", "www.bfkdim.com");
    }

    public String getVerify(String number, String send, String indexs1, String indexs2) {
        httpGet.setURI(URI.create("https://www.bfkdim.com/messages?phone=" + number));
        String html = null;
        String rut = null;
        try {
            CloseableHttpResponse execute = client.execute(httpGet);
            HttpEntity entity = execute.getEntity();
            html = EntityUtils.toString(entity);
            execute.close();
        } catch (Exception e) {
            System.out.println("请求连接超时");
            e.printStackTrace();
        }
        Document documents = Jsoup.parse(html);
        Elements select = documents.select("body > div:nth-child(7) > div.panel.panel-default");
        for (Element element : select) {
            String text = element.select("div.panel-body > span").text();
            if (!text.equals("站长推荐") & !text.equals("google")) {
                String text1 = element.select("div.panel-footer > a").text();
                String text2 = element.select("div.panel-footer > a > span").text();
                int i = text1.indexOf(indexs1);
                int j = text1.indexOf(indexs2);
                if (i >= 0 & j >= 0 & i != j & i < j) {
                    String substring = text1.substring(i + 1, j);
                    if (substring.equals(send)) {
                        rut = text1 + "-----" + text2;
                        return rut;
                    }
                }
            }
        }
        return rut;
    }

    public List<String> getNote(String site) {
        String html = null;
        List<String> list = new ArrayList<>();
        for (int index = 0; index < 9; index++) {
            try {
                httpGet.setURI(URI.create("https://www.bfkdim.com/?page=" + index));
                CloseableHttpResponse execute = client.execute(httpGet);
                HttpEntity entity = execute.getEntity();
                html = EntityUtils.toString(entity);
                execute.close();
            } catch (IOException e) {
                System.out.println("请求连接超时");
                e.printStackTrace();
            }
            Document document = Jsoup.parse(html);
            Elements phone_style = document.select("body > div.container.home-container > div.phone_style > div" +
                    ".phone_col" +
                    ".phone_col_blue.col-md-4.col-xs-12.col-sm-12");
            for (int i = 0; i < phone_style.size(); i++) {
                Element element = phone_style.get(i);
                Elements select = element.select("div.phone_item > div.inner");
                String sites = select.select("div.phone_col_head >span").text();
                String number = select.select("div.phone_col_head > a").text();
                String url = select.select("div.phone_col_head > a").attr("href");
                String amount = select.select("div.phone_col_body.clearfix > div > div > span > b").get(0).text();
                if (sites.equals(site)) {
                    list.add(sites + "-----" + number + "-----https://www.bfkdim.com/messages?" + url + "-----" + amount);
                }
            }
        }
        return list;
    }
}

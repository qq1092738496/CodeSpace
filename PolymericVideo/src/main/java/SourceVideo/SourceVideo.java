package SourceVideo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.Videodao;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pojo.Video;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Andy
 * @time: 2021/8/20 19:18
 */


public class SourceVideo {

    public List<Map<String, String>> yi(String url) {
        System.out.println("执行该页获取爬去所有链接！");
        CloseableHttpClient client = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, " +
                "like Gecko) Chrome/92.0.4515.159 Safari/537.36");
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        CloseableHttpResponse execute = null;
        try {
            for (int i = 1; i <= 1; i++) {
                try {
                    execute = client.execute(httpGet, HttpClientContext.create());
                } catch (Exception e) {
                    System.out.println("获取全部基础链接出错，可能是网络延迟问题，可能无法显示" + e);
                    i = 0;
                }
            }
            HttpEntity entity = execute.getEntity();
            Document parse = Jsoup.parse(EntityUtils.toString(entity));
            Elements select = parse.select("#main > div > div.module > div.module-list > div.module-items > div" +
                    ".module-item");

            InputStream resource = null;
            try {
                resource = Resources.getResourceAsStream("Videomapper.xml");
            } catch (IOException e) {
                e.printStackTrace();
            }
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            Videodao mapper1 = sqlSession.getMapper(Videodao.class);

            for (Element element : select) {
                Map<String, String> map = new HashMap<String, String>();
                Elements a = element.select(".module-item-cover > a");
                String Video_Name = a.attr("title");
                String Quality = element.select(".module-item-text").text();
                String url2 = "http://dianying.im" + a.attr("href");
                if (null == mapper1.View_one_Video(Video_Name)) {
                    map.put("Video_Name", Video_Name); //名字
                    map.put("Quality", Quality);//质量
                    map.put("url", url2); //详情链接
                    list.add(map);
                } else {
                    if (url2 != null && url2 != "") {

                        System.out.println("\n----------------------------\n" + "<<" + a.attr("title") + ">>");
                        LinkedHashMap<String, LinkedHashMap<String, String>> linkmap =
                                new LinkedHashMap<String, LinkedHashMap<String, String>>();
                        LinkedHashMap<String, LinkedHashMap<String, String>> erlinkmap =
                                new LinkedHashMap<String, LinkedHashMap<String, String>>();
                        ObjectMapper objectMapper = new ObjectMapper();
                        Object o = er(url2).get("play");
                        String s = mapper1.PlaySelect(Video_Name);
                        linkmap = objectMapper.readValue(s, linkmap.getClass());
                        erlinkmap = objectMapper.readValue(o.toString(), erlinkmap.getClass());
                        for (String s1 : erlinkmap.keySet()) {
                            if (linkmap.get(s1) != null) {
                                LinkedHashMap<String, String> LinkedHashMap = linkmap.get(s1);
                                LinkedHashMap<String, String> erLinkedHashMap = erlinkmap.get(s1);
                                for (String s2 : erLinkedHashMap.keySet()) {
                                    if (LinkedHashMap.get(s2) != null) {
                                        System.out.println(s1 + "节点:" + s2 + "  " + "正确");
                                    } else {
                                        mapper1.removeNmae(Video_Name);
                                        sqlSession.commit();
                                        System.out.println(s1 + "节点:" + s2 + "  " + "集数不正确，添加待爬目录");
                                        map.put("Video_Name", Video_Name); //名字
                                        map.put("Quality", Quality);//质量
                                        map.put("url", url2); //详情链接
                                        list.add(map);
                                        break;
                                    }
                                }
                            } else {
                                mapper1.removeNmae(Video_Name);
                                sqlSession.commit();
                                System.out.println(s1 + "  " + ":节点不正确，添加待爬目录");
                                map.put("Video_Name", Video_Name); //名字
                                map.put("Quality", Quality);//质量
                                map.put("url", url2); //详情链接
                                list.add(map);
                                break;
                            }

                        }
                    }
                }
            }

            resource.close();
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Map<String, Object> er(String url) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (url != null) {
            CloseableHttpClient client = HttpClients.createDefault();

            HttpGet httpGet = new HttpGet(url);
            httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, " +
                    "like Gecko) Chrome/92.0.4515.159 Safari/537.36");
            try {
                CloseableHttpResponse execute = null;
                for (int i = 1; i <= 1; i++) {
                    try {
                        execute = client.execute(httpGet, HttpClientContext.create());
                    } catch (Exception e) {
                        System.out.println("获取全部播放链接出错，可能是网络延迟问题，可能无法显示" + e);
                        i = 0;
                    }
                }
                HttpEntity entity = execute.getEntity();
                Document parse = Jsoup.parse(EntityUtils.toString(entity));
                Elements entitys = parse.select("#main > div > div.box.view-heading");
                Elements head = entitys.select("div.video-info > div" +
                        ".video-info-header");
                map.put("label",
                        head.select("div.video-info-aux > a").text() + " " + head.select("div.video-info-aux > div").text());
                //标签

                Elements body = entitys.select("div.video-info > div.video-info-main");
                Elements div = body.select("div.video-info-items");
                for (Element element : div) {
                    if (element.select("span").text().startsWith("导演：")) {
                        map.put("Director", element.select("a").text());
                    } else if (element.select("span").text().startsWith("编剧：")) {
                        map.put("Screenwriter", element.select("a").text());
                    } else if (element.select("span").text().startsWith("主演：")) {
                        map.put("Starring", element.select("div > a").text());
                    } else if (element.select("span").text().startsWith("上映：")) {
                        map.put("Release_Time", element.select("div.video-info-item").text());
                    } else if (element.select("span").text().startsWith("片长：")) {
                        map.put("Film_length", element.select("div.video-info-item").text());
                    } else if (element.select("span").text().startsWith("剧情：")) {
                        map.put("Introduce", element.select("div.video-info-item.video-info-content").text());
                    }
                }

                Elements img = entitys.select("div.video-cover > div > div");
                map.put("Cover", img.select("img").attr("src"));  //封面

                Elements module = parse.select("#main > div > div:nth-child(2)");
                Elements select = module.select("div.module-heading > div.module-tab.module-player-tab > div > div" +
                        ".module-tab-content > div");
                Elements select1 = module.select("div.module-list.module-player-list.tab-list.sort-list");
                LinkedHashMap<String, LinkedHashMap<String, String>> linkmap = new LinkedHashMap<String,
                        LinkedHashMap<String, String>>();

                if (!img.select("a").isEmpty()) {
                    for (int i = 0; i < select.size(); i++) {
                        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
                        Elements select2 = select1.get(i).select("div.module-blocklist.scroll-box.scroll-box-y > div " +
                                "> a");
                        for (Element element : select2) {
                            linkedHashMap.put(element.select("span").text(), "http://dianying.im/" + element.attr(
                                    "href"));
                        }
                        linkmap.put(select.get(i).select("span").text(), linkedHashMap); //节点
                    }
                } else {
                    linkmap.put(null, null);
                }
                if (!linkmap.isEmpty()) {
                    ObjectMapper mapper = new ObjectMapper();
                    String s = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(linkmap);
                    System.out.println(s);
                    map.put("play", s);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            map = null;
            System.out.println("url是空的");
        }
        return map;
    }

    public LinkedHashMap<String, LinkedHashMap<String, String>> san(String Video_Name, LinkedHashMap<String,
            LinkedHashMap<String,
                    String>> linkedHashMap) {
        System.out.println("\n-------开始下载--------\n<<" + Video_Name + ">>\n" + linkedHashMap);
        System.getProperties().setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("D:\\Tool Assistant\\Google\\Chrome\\Application\\chrome.exe");
        //options.addArguments("--headless"); //无头模式
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-plugins"); //禁止插件
        options.addArguments("--disable-images");//禁止图像
        options.addArguments("--disable-popup-blocking");//禁止弹窗
        options.addArguments("blink-settings=imagesEnabled=false");//不加载图片
        ChromeDriver chrome = new ChromeDriver(options);

        JavascriptExecutor js = chrome;

        if (linkedHashMap != null) {
            for (String s : linkedHashMap.keySet()) {
                LinkedHashMap<String, String> linkedHashMap1 = linkedHashMap.get(s);
                for (String s1 : linkedHashMap1.keySet()) {
                    for (int i = 1; i <= 1; i++) {
                        try {
                            chrome.get(linkedHashMap1.get(s1));
                            Boolean webDriverWait =
                                    new WebDriverWait(chrome, 10,
                                            (long) 0.2).until(ExpectedConditions.javaScriptThrowsNoExceptions("return" +
                                            " " +
                                            "parent.MacPlayer.PlayUrl"));
                            System.out.println(s1 + " : " + linkedHashMap1.get(s1) + "下载成功");
                            String XzUrl = js.executeScript("return parent.MacPlayer.PlayUrl").toString();

                            if (webDriverWait == true || XzUrl != null) {
                                linkedHashMap1.put(s1, XzUrl);
                            } else {
                                linkedHashMap1.put(s1, null);
                            }
                        } catch (Exception e) {
                            System.out.println("selenium报错，多半是网速延迟,重复请求" + e);
                            i = 0;
                        }
                    }
                }
                linkedHashMap.put(s, linkedHashMap1);
            }
            chrome.close();
            chrome.quit();
        } else {
            System.out.println("下载地址集合是空的");
        }
        return linkedHashMap;
    }

    private void he(String url) {
        if (url != null) {
            ObjectMapper mapper = new ObjectMapper();
            List<Map<String, String>> yi = yi(url);

            for (Map<String, String> map : yi) {
                Map<String, Object> er = er(map.get("url"));

                LinkedHashMap<String, LinkedHashMap<String, String>> linkedHashMap = new LinkedHashMap<String,
                        LinkedHashMap<String, String>>();
                try {
                    linkedHashMap = mapper.readValue(er.get("play").toString(), linkedHashMap.getClass());
                    LinkedHashMap<String, LinkedHashMap<String, String>> san = san(map.get("Video_Name"),
                            linkedHashMap);
                    er.put("play", mapper.writerWithDefaultPrettyPrinter().writeValueAsString(san));
                    Video video = new Video();
                    video.setCover(er.get("Cover").toString());
                    video.setVideo_Name(map.get("Video_Name"));
                    video.setQuality(map.get("Quality"));
                    if (null != er.get("Director")) {
                        video.setDirector(er.get("Director").toString());
                    } else {
                        video.setDirector(null);
                    }
                    if (null != er.get("Screenwriter")) {
                        video.setScreenwriter(er.get("Screenwriter").toString());
                    } else {
                        video.setScreenwriter(null);
                    }
                    if (null != er.get("Starring")) {
                        video.setStarring(er.get("Starring").toString());
                    } else {
                        video.setStarring(null);
                    }
                    if (null != er.get("Introduce")) {
                        video.setIntroduce(er.get("Introduce").toString());
                    } else {
                        video.setIntroduce(null);
                    }
                    if (null != er.get("Release_Time")) {
                        video.setRelease_Time(er.get("Release_Time").toString());
                    } else {
                        video.setRelease_Time(null);
                    }
                    if (null != er.get("Film_length")) {
                        video.setFilm_length(er.get("Film_length").toString());
                    } else {
                        video.setFilm_length(null);
                    }
                    if (null != er.get("label")) {
                        video.setLabel(er.get("label").toString());
                    } else {
                        video.setLabel(null);
                    }
                    if (null != er.get("play")) {
                        video.setPlay(er.get("play").toString());
                    } else {
                        video.setLabel(null);
                    }
                    try {
                        InputStream resource = Resources.getResourceAsStream("Videomapper.xml");
                        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);
                        SqlSession sqlSession = sqlSessionFactory.openSession();
                        Videodao mapper1 = sqlSession.getMapper(Videodao.class);

                        int i = mapper1.addVideo(video);
                        if (i == 1) {
                            System.out.println(video + "\n---------------------------\n" + "添加数据库成功！\n\n");
                            sqlSession.commit();
                            resource.close();
                            sqlSession.close();
                        }
                    } catch (Exception e) {
                        System.out.println("数据库异常" + e);
                        e.printStackTrace();
                    }
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("要爬取的url页面为空");
        }

    }

    public void start(String url) {
        if (url != null) {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpGet get = new HttpGet(url);
            CloseableHttpResponse execute = null;
            for (int i = 1; i <= 1; i++) {
                try {
                    execute = client.execute(get);
                } catch (Exception e) {
                    System.out.println("网络连接有问题，获取总页数失败，重复获取");
                    i = 0;
                }
            }

            get.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, " +
                    "like Gecko) Chrome/92.0.4515.159 Safari/537.36");
            try {
                String s = EntityUtils.toString(execute.getEntity());
                Document parse = Jsoup.parse(s);
                Elements select = parse.select("#page > a:nth-child(9)");
                String href = select.attr("href");
                String[] split = href.split("--------");
                String[] split1 = split[1].split("---/");
                if (null != split1) {
                    String[] split2 = url.split("--------");

                    Integer integer = Integer.valueOf(split1[0]);
                    String text =
                            parse.select("#main > div > div.page-heading > div > div:nth-child(7) > h2 > span").text();
                    System.out.println("共有" + text + "部影片.\n" + "每页显示72条数据,共" + integer + "页!\n");

                    String[] ur1 = url.split("--------");
                    String[] ur2 = ur1[1].split("---/");
                    Integer ur3 = Integer.valueOf(ur2[0]);
                    for (; ur3 <= integer; ur3++) {
                        System.out.println("开始抓取第" + ur3 + "页.");
                        he(split2[0] + "--------" + ur3 + "---/");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("没有传入url");
        }
    }

    public static void main(String[] args) {
         SourceVideo sourceVideo = new SourceVideo();
         sourceVideo.start("https://www.hsyipos.com/vodtype/1.html");
    }
}

package com.medititation.Basic_Data.Commodity;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * @description:
 * @author: Andy
 * @time: 2022/4/12 21:58
 */

public class getCommodity {
    public static void getCommditys(String Cookie, String UA) {
        String url = "https://detail.tmall.com/item.htm?spm=a230r.1.14.16" +
                ".61ac4f64Hs4xAZ&id=665099551540&ns=1&abbucket=10";
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("cookie", Cookie);
        httpGet.setHeader("user_Akeng", UA);
        ObjectMapper mapper = new ObjectMapper();
        try {
            if (url.startsWith("https://detail.tmall.com/")) {
                String html = EntityUtils.toString(client.execute(httpGet).getEntity());
                Document body = Jsoup.parse(html);

                Elements script = body.select("script");
                int y = 0;
                if (script.size() <= 39) {
                    y = 30;
                } else if (script.size() >= 39) {
                    y = 39;
                }
                String data = script.get(y).data();  //优衣库39个 一般都是30个
                String[] split = data.split("TShop.Setup\\(");
                String[] split1 = split[1].split("}\\)\\(\\);");
                String[] split2 = split1[0].trim().split("\t  \\);");
                JsonNode jsonNode = mapper.readValue(split2[0], JsonNode.class);
                System.out.println(jsonNode);

                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                //关键字标题
                System.out.println("关键字标题:" + jsonNode.get("itemDO").get("title").asText());

                //发货地址
                System.out.println("发货地址:" + jsonNode.get("itemDO").get("prov").asText());
                //品牌名
                System.out.println("品牌名:" + jsonNode.get("itemDO").get("brand").asText());

                //产品参数
                Elements select2 = body.select("#J_AttrUL > li");
                LinkedHashMap<String, String> parameter = new LinkedHashMap<>();
                for (Element element : select2) {
                    String[] split3 = element.text().split(": ");
                    if (split3.length <= 1) {
                        split3 = element.text().split("：");
                    }
                    parameter.put(split3[0], element.attr("title"));
                }
                System.out.println("产品参数:" + parameter);
                //四张首图
                LinkedList linkedList = new LinkedList();
                for (JsonNode node : jsonNode.get("propertyPics").get("default")) {
                    linkedList.add(node.asText());
                }
                System.out.println("四张首图:" + linkedList);

                //详情页
                String s = jsonNode.get("api").get("descUrl").asText();
                HttpGet Get = new HttpGet("https:" + s);
                String hm = EntityUtils.toString(client.execute(Get).getEntity());
                Document parse = Jsoup.parse(hm);
                LinkedList<String> list = new LinkedList<String>();
                Elements img = parse.select("img");
                for (Element element : img) {
                    String src = element.attr("src");
                    if (src.endsWith(".jpg")) {
                        list.add(src);
                    }
                }

                System.out.println("详情页" + list);

                Elements select = body.select("#J_DetailMeta > div.tm-clear > div.tb-property > div > div.tb-key > " +
                        "div > div > dl");
                LinkedHashMap<String, LinkedHashMap<String, String>> linkedHashMap = new LinkedHashMap<>();
                for (int i = 0; i < select.size(); i++) {
                    String dt = select.get(i).select("dt").text();


                    if (!dt.equals("数量") | !dt.equals("花呗分期") | !dt.equals("") | !dt.equals("版本") | !dt.equals(
                            "服务")) {
                        System.out.println(dt);
                        System.out.println(!dt.equals("花呗分期"));
                        Elements s1 = select.get(i).select("dd > ul > li");
                        LinkedHashMap<String, String> map = new LinkedHashMap<>();
                        for (int j = 0; j < s1.size(); j++) {
                            String pvs = s1.get(j).attr("data-value");
                            String text = s1.get(j).select("a > span").text();
                            map.put(pvs, text);
                        }
                        linkedHashMap.put(dt, map);
                    }
                }
                System.out.println(linkedHashMap);


            } else if (url.startsWith("https://item.taobao.com/")) {
                String html = EntityUtils.toString(client.execute(httpGet).getEntity());
                String[] split = Jsoup.parse(html).select("script").get(0).data().split("var g_config = ");
                String[] split1 = split[1].split("g_config.tadInfo");
                System.out.println(split1[0].trim());

            }

           /* String text = head.select("div.tm-clear > div.tb-property > div > div.tb-detail-hd > h1").text(); //关键词
            String text1 = head.select("#J_PromoPrice > dd > div > span").text();//价格*/


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

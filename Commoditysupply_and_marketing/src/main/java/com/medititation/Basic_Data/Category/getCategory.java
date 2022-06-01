package com.medititation.Basic_Data.Category;

import com.medititation.util.jdbc;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * @description:
 * @author: Andy
 * @time: 2022/4/8 1:47
 */

public class getCategory {
    //一级类目手动添加，获取二级类目
    public static void getSecondary_category(String url) throws IOException, SQLException {
        try {
            CloseableHttpClient Client = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse execute = Client.execute(httpGet);
            HttpEntity entity = execute.getEntity();
            String html = EntityUtils.toString(entity);
            Document parse = Jsoup.parse(html);
            Elements elements = parse.selectXpath("/html/body/div[@class='home-category-list J_Module']");

            LinkedHashMap<String, ArrayList<String>> listHashMap = new LinkedHashMap<>();
            for (int i = 0; i < elements.size(); i++) {
                String text = elements.get(i).selectFirst("div > a").text();
                Elements selet = elements.get(i).select("div > ul > li");
                ArrayList<String> list = new ArrayList<>();
                for (int j = 0; j < selet.size(); j++) {
                    list.add(selet.get(j).selectFirst("a").text());
                }
                listHashMap.put(text, list);
            }
            Object[] keys = listHashMap.keySet().toArray();


            Connection connections = jdbc.Connections();
            String select = "SELECT COLUMN_NAME Name FROM information_schema.COLUMNS WHERE TABLE_NAME = 'category' " +
                    "AND " +
                    "COLUMN_NAME = ?";
            String input = "INSERT INTO category (女装男装,鞋类箱包,母婴用品,护肤彩妆,汇吃美食,珠宝配饰,家装建材,家居家纺,百货市场,汽车·用品,手机数码,家电办公," +
                    "更多服务,生活服务,运动户外,花鸟文娱,农资采购) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement Psment = connections.prepareStatement(select);
            PreparedStatement Psment1 = connections.prepareStatement(input);
            int size = 0;
            int a = 0;
            for (int i = 0; i < keys.length; i++) {
                int sizea = listHashMap.get(keys[a]).size();
                int sizei = listHashMap.get(keys[i]).size();
                if (sizea <= sizei) {
                    a = i;
                    size = sizea;
                }
            }

            ArrayList<ArrayList<String>> lists = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                ArrayList<String> list = new ArrayList<>();
                for (int i = 0;i < keys.length; i++) {
                    try {
                        String data = listHashMap.get(keys[i]).get(j);
                        list.add(data);
                    } catch (IndexOutOfBoundsException e) {
                        list.add(null);
                    }
                }
                lists.add(list);
            }
            for (int i = 0; i < lists.size(); i++) {
                Psment1.setString(1, lists.get(i).get(0));
                Psment1.setString(2, lists.get(i).get(1));
                Psment1.setString(3, lists.get(i).get(2));
                Psment1.setString(4, lists.get(i).get(3));
                Psment1.setString(5, lists.get(i).get(4));
                Psment1.setString(6, lists.get(i).get(5));
                Psment1.setString(7, lists.get(i).get(6));
                Psment1.setString(8, lists.get(i).get(7));
                Psment1.setString(9, lists.get(i).get(8));
                Psment1.setString(10, lists.get(i).get(9));
                Psment1.setString(11, lists.get(i).get(10));
                Psment1.setString(12, lists.get(i).get(11));
                Psment1.setString(13, lists.get(i).get(12));
                Psment1.setString(14, lists.get(i).get(13));
                Psment1.setString(15, lists.get(i).get(14));
                Psment1.setString(16, lists.get(i).get(15));
                Psment1.setString(17, lists.get(i).get(16));
                Psment1.execute();
                System.out.println(Psment1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

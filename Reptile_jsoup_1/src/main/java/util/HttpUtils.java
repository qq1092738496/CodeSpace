package util;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HttpUtils {
    public String  dourl(String id,String count,int page){
        String url = "https://huaban.com/discovery/beauty/?k98ko493&max="+id+"&limit="+count+"&wfl="+page;
        return url;
    }

    public Map<String, String> httpdoget(String url, String Cookie) {

        String id = null;
        Map<String, String> map = new HashMap<String, String>();
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("Cookie", Cookie);
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.113 Safari/537.36");
        httpGet.setHeader("X-Request", "JSON");
        httpGet.setHeader("X-Requested-With", "XMLHttpRequest");
        try {
            CloseableHttpResponse response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String data = EntityUtils.toString(entity);

            //json转处理
            JSONObject jsonObject = JSONObject.parseObject(data);
            JSONArray pins = jsonObject.getJSONArray("pins");
            JSONObject jsonObject1 = pins.getJSONObject(1);
            JSONObject file1 = jsonObject1.getJSONObject("file");

            for (int i = 0; i < pins.size(); i++) {
                JSONObject Object = pins.getJSONObject(i);
                JSONObject file = Object.getJSONObject("file");
                map.put(file.getString("pin_id"), file.getString("key"));
                id = file.getString("pin_id");
            }
            map.put("ok", id);
            response.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public String  download(Map<String, String> map) {
        String id = null;
        int j1 =1;
        try {
            CloseableHttpClient client = HttpClients.createMinimal();
            Set<String> keySet = map.keySet();
            for (String pin_id : keySet) {
                HttpGet httpGet = new HttpGet("https://hbimg.huabanimg.com//" + map.get(pin_id));
                httpGet.setHeader("user-agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.113 Safari/537.36");
                CloseableHttpResponse execute = client.execute(httpGet);
                byte[] bytes = EntityUtils.toByteArray(execute.getEntity());
                System.out.println(Arrays.toString(bytes));
                BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream("F:\\haha\\" + pin_id + ".jpg"));
                output.write(bytes);

                System.out.println(pin_id+"下载完成" +j1+"张");
                j1=j1+1;


                id = map.get("ok");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
            return id;
    }


}

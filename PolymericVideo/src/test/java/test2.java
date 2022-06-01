import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Andy
 * @time: 2022/1/26 17:50
 */

public class test2 {
    CloseableHttpClient httpClient = HttpClients.createDefault();
    ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) {
        test2 test2 = new test2();
        test2.he("F:\\Download");
    }


    public void he(String path) {
        try {
            test2 test2 = new test2();
            String s = test2.gainVideoPath();
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readValue(s, JsonNode.class);
            for (int i = 0; i < jsonNode.size(); i++) {
                String title = jsonNode.get(i).get("title").asText();
                if (!test2.detectionFile(title, path)) {
                    test2.creationFile(path, title);

                    String s1 = test2.parseVideoPath(jsonNode.get(i).get("bvid").asText());
                    JsonNode jsonNode1 = mapper.readValue(s1, jsonNode.getClass());
                    for (int i1 = 0; i1 < jsonNode1.size(); i1++) {
                        String s2 = mapper.writeValueAsString(jsonNode1.get(i1));
                        Map<String, byte[]> stringMap = test2.downloadVideo(s2);

                        FileOutputStream outputStream =
                                new FileOutputStream(new File(path + title + "\\" + jsonNode1.get(i1).get("name").asText()+
                                        ".m4s"));
                        outputStream.write(stringMap.get("video"));
                        outputStream.write(stringMap.get("audio"));

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取收藏夹当内容
    public String gainVideoPath() {
        HttpGet httpGet = new HttpGet("https://api.bilibili.com/x/v3/fav/resource/list?media_id=1489575008&pn=1&ps=20" +
                "&keyword=&order=mtime&type=0&tid=0&platform=web&jsonp=jsonp");
        httpGet.setHeader("cookie", "buvid3=E9F62E4A-F70E-0844-E78C-3FD8D392E6DC85278infoc; " +
                "_uuid=2D3A1C41-69D4-CF6D-7345-89F7453C67D187662infoc; i-wanna-go-back=-1; " +
                "fingerprint=909f817875407b43c66bbc517af9474e; buvid_fp_plain=undefined; " +
                "SESSDATA=b07f5861%2C1658487876%2Cf5d76%2A11; bili_jct=a41a151ac1dc8e9e97ec14d50abd937d; " +
                "DedeUserID=397302808; DedeUserID__ckMd5=a4b9025efa92f36f; sid=lfuwuw9k; b_ut=5; CURRENT_BLACKGAP=0; " +
                "blackside_state=0; rpdid=|(u)YYkRmY)l0J'uYRkmJY|J|; LIVE_BUVID=AUTO4616429374772633; " +
                "buvid_fp=0f381f89fc718edc8171198a206fdde2; CURRENT_FNVAL=4048; " +
                "buvid4=18B238E1-0A5F-78FB-4787-0AE315B1906212704-022012616-/90KX6FxwkgG3nSQuyKS1g%3D%3D; " +
                "b_lsid=24C10E4F3_17E95C0A9C3; PVID=3; bp_video_offset_397302808=619990714002979100; innersign=1; " +
                "CURRENT_QUALITY=80");


        String datapath = null;
        try {
            CloseableHttpResponse execute = httpClient.execute(httpGet);
            HttpEntity entity = execute.getEntity();
            String json = EntityUtils.toString(entity);
            JsonNode jsonNode = objectMapper.readValue(json, JsonNode.class);
            JsonNode data = jsonNode.get("data").get("medias");

            List<Map<String, String>> dataJsonNode = new ArrayList<Map<String, String>>();
            for (int i = 0; i < data.size(); i++) {
                JsonNode medias = data.path(i);

                Map<String, String> datamap = new HashMap<String, String>();
                datamap.put("title", medias.get("title").asText());
                datamap.put("id", medias.get("id").asText());
                datamap.put("bvid", medias.get("bvid").asText());
                datamap.put("name", medias.get("upper").get("name").asText());
                dataJsonNode.add(datamap);
            }
            datapath = objectMapper.writeValueAsString(dataJsonNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datapath;
    }

    //给定一个网址，即可以获取其中所有视频
    public String parseVideoPath(String bvid) {
        String json = null;
        try {
            HttpGet httpGet = new HttpGet("https://api.bilibili.com/x/player/pagelist?bvid=" + bvid + "&jsonp" +
                    "=jsonp");
            CloseableHttpResponse execute1 = httpClient.execute(httpGet);
            JsonNode jsonNode = objectMapper.readValue(EntityUtils.toString(execute1.getEntity()), JsonNode.class);
            JsonNode data = jsonNode.get("data");
            List<Map<String, String>> mapList = new ArrayList<Map<String, String>>();
            for (int i = 1; i <= data.size(); i++) {
                String url2 = "https://www.bilibili.com/video/" + bvid + "?P=" + i;
                httpGet.setURI(URI.create(url2));
                CloseableHttpResponse execute2 = httpClient.execute(httpGet);
                Document parse1 = Jsoup.parse(EntityUtils.toString(execute2.getEntity()));
                Elements select = parse1.select("head > script");
                String s = select.get(3).toString().split("<script>window.__playinfo__=")[1].split("</script>")[0];

                JsonNode jsonNode1 = objectMapper.readValue(s, jsonNode.getClass());
                JsonNode jsonNode2 = jsonNode1.get("data").get("dash").get("video").get(0);
                JsonNode jsonNode3 = jsonNode1.get("data").get("dash").get("audio").get(0);
                Map<String, String> map = new HashMap<String, String>();
                //page
                map.put("part", data.get(i - 1).get("page").asText());
                //name
                map.put("name", data.get(i - 1).get("part").asText());
                //视频
                map.put("video", jsonNode2.get("base_url").asText());
                //音频
                map.put("audio", jsonNode3.get("base_url").asText());

                //来源
                map.put("referer", url2);

                mapList.add(map);
            }

            json = objectMapper.writeValueAsString(mapList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    //下载m4s中当视频，返回byte[]数组 map集合
    public Map<String, byte[]> downloadVideo(String path) {
        Map<String, byte[]> bytemap = new HashMap<String, byte[]>();
        try {
            JsonNode jsonNode = objectMapper.readValue(path, JsonNode.class);
            String video = jsonNode.get("video").asText();
            String audio = jsonNode.get("audio").asText();
            String referer = jsonNode.get("referer").asText();
            HttpGet httpGet = new HttpGet(video);
            httpGet.setHeader("referer", referer);
            CloseableHttpResponse execute = httpClient.execute(httpGet);
            byte[] vieoByte = EntityUtils.toByteArray(execute.getEntity());
            httpGet.setURI(URI.create(audio));
            CloseableHttpResponse execute1 = httpClient.execute(httpGet);
            byte[] audioByte = EntityUtils.toByteArray(execute1.getEntity());
            bytemap.put("video", vieoByte);
            bytemap.put("audio", audioByte);


        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytemap;
    }
    //检查文件是否有该文件夹

    public boolean detectionFile(String name, String filepath) {
        File file = new File(filepath);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].getName().equals(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void creationFile(String path, String title) {
        if (title.indexOf("/") != -1) {
            title = title.replace("/", " ");
        }
        File file = new File(path + title);
        file.mkdir();
    }
}

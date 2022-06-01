package SourceVideo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.ConnectionClosedException;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Andy
 * @time: 2022/1/28 20:19
 */

public class downloadVideo {
    public static void main(String[] args) {
        String cookie = "_uuid=29F1010941-C109C-35FF-9E105-6744E746625775308infoc; b_nut=1647701477; " +
                "buvid3=0BFF9FF2-115E-AF9B-8DDC-B38AADFC9A1176683infoc; " +
                "buvid4=27FAF74D-A9B5-270C-845E-2FBD0F93E08A76683-022031922-/90KX6FxwkjPcnqHFLSPQg%3D%3D; PVID=1; " +
                "i-wanna-go-back=-1; fingerprint=3742942e513f2655570974beccf08fbc; buvid_fp_plain=undefined; " +
                "SESSDATA=4bc5d6a2%2C1663863519%2C2e23a%2A31; bili_jct=7d3e21cb8f46c2ec598b4edbc6ad9dd9; " +
                "DedeUserID=397302808; DedeUserID__ckMd5=a4b9025efa92f36f; sid=jhw2zmje; " +
                "LIVE_BUVID=AUTO2016483115231762; buvid_fp=3742942e513f2655570974beccf08fbc; CURRENT_BLACKGAP=0; " +
                "blackside_state=0; rpdid=0zbfAHTqOc|me1meGV5|4j5|3w1Ny9Db; b_ut=5; nostalgia_conf=-1; " +
                "bp_video_offset_397302808=643296907440947200; b_lsid=AB104110410_17FDBBF3B28; innersign=1; " +
                "CURRENT_FNVAL=4048";
        String favorite = "https://api.bilibili.com/x/v3/fav/resource/list?media_id=1489575008&pn=1&ps=20" +
                "&keyword=&order=mtime&type=0&tid=0&platform=web&jsonp=jsonp";
        downloadVideo downloadVideo = new downloadVideo();
        downloadVideo.integrate(cookie, favorite, "F:\\Download\\");
    }

    //整合
    public void integrate(String cookie, String favorite, String url) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String favoritejson = gainVideoPath(cookie, favorite);
            JsonNode favoritejsonNode = mapper.readValue(favoritejson, JsonNode.class);
            for (int i = 0; i < favoritejsonNode.size(); i++) {
                String bvid = favoritejsonNode.get(i).get("bvid").asText();
                String title = updataFile(favoritejsonNode.get(i).get("title").asText());
                if (!detectionFile(title, url)) {
                    File file = new File(url + "\\" + title);
                    file.mkdir();
                    System.out.println(file.getName());
                    String VideoPath = parseVideoPath(bvid);
                    JsonNode VideoPathjsonNode = mapper.readValue(VideoPath, JsonNode.class);
                    for (int j = 0; j < VideoPathjsonNode.size(); j++) {
                        String name = updataFile(VideoPathjsonNode.get(j).get("name").asText());
                        String video = VideoPathjsonNode.get(j).get("video").asText();
                        String audio = VideoPathjsonNode.get(j).get("audio").asText();
                        String referer = VideoPathjsonNode.get(j).get("referer").asText();
                        System.out.println(VideoPathjsonNode.get(j));
                        Map<String, byte[]> byteMap = downloadVideo(cookie, video, audio, referer);
                        for (String key : byteMap.keySet()) {
                            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(new File(url + "\\" + title +
                                    "\\" + key + name + ".m4s")));
                            System.out.println(url + "\\" + title +
                                    "\\" + key + name + ".m4s");
                            outputStream.write(byteMap.get(key));
                            outputStream.close();
                        }
                        String dos = "ffmpeg -loglevel quiet -i \"" + url + "\\" + title +
                                "\\video" + name + ".m4s\"" + " -i \"" + url + "\\" + title +
                                "\\audio" + name + ".m4s\"" + " -codec copy \"" + url + "\\" + title +
                                "\\" + name + ".mp4\"";
                        System.out.println(dos);
                        Process exec = Runtime.getRuntime().exec(dos);
                        if (exec.waitFor() == 0) {
                            File videodelete = new File(url + "\\" + title +
                                    "\\video" + name + ".m4s");
                            File audiodelete = new File(url + "\\" + title +
                                    "\\audio" + name + ".m4s");
                            videodelete.delete();
                            audiodelete.delete();
                            exec.destroy();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取收藏夹当内容
    public String gainVideoPath(String cookie, String favorite) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        ObjectMapper objectMapper = new ObjectMapper();
        HttpGet httpGet = new HttpGet(favorite);
        httpGet.setHeader("cookie", cookie);


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
        System.out.println("获取收藏夹json：\n" + favorite + "\n" + datapath + "\n");
        return datapath;
    }

    //给定一个网址，即可以获取其中所有视频
    public String parseVideoPath(String bvid) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            HttpGet httpGet = new HttpGet("https://api.bilibili.com/x/player/pagelist?bvid=" + bvid + "&jsonp=jsonp");
            CloseableHttpResponse execute1 = httpClient.execute(httpGet);
            JsonNode jsonNode = objectMapper.readValue(EntityUtils.toString(execute1.getEntity()), JsonNode.class);
            System.out.println("获取目录cid：\n" + "https://api.bilibili.com/x/player/pagelist?bvid=" + bvid + "&jsonp" +
                    "=jsonp" +
                    "\n" + jsonNode + "\n");
            JsonNode data = jsonNode.get("data");
            List<Map<String, String>> mapList = new ArrayList<Map<String, String>>();
            for (int i = 0; i < data.size(); i++) {
                String cid = data.get(i).get("cid").asText();
                String url2 = "https://api.bilibili.com/x/player/playurl?bvid=" + bvid + "&cid=" + cid + "&qn=80" +
                        "&fnver=0" +
                        "&fnval" +
                        "=2000&otype=json";
                HttpGet get = new HttpGet(url2);
                CloseableHttpResponse execute2 = httpClient.execute(get);
                String s = EntityUtils.toString(execute2.getEntity());

                JsonNode jsonNode1 = objectMapper.readValue(s, JsonNode.class);

                JsonNode jsonNode2 = jsonNode1.get("data").get("dash").get("video").get(0);
                JsonNode jsonNode3 = jsonNode1.get("data").get("dash").get("audio").get(0);
                Map<String, String> map = new HashMap<String, String>();
                //page
                map.put("part", data.get(i).get("page").asText());
                //name
                map.put("name", data.get(i).get("part").asText());
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
        System.out.println("获取下载地址：\n" +json);
        return json;
    }

    //下载m4s中当视频，返回byte[]数组 map集合
    public Map<String, byte[]> downloadVideo(String cookie, String video, String audio, String referer) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        Map<String, byte[]> bytemap = new HashMap<String, byte[]>();
        boolean i = true;
        while (i) {
            try {
                HttpGet httpGet = new HttpGet(video);
                httpGet.setHeader("referer", "https://api.bilibili.com/");
                httpGet.setHeader("user-agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, " +
                        "like Gecko) Chrome/99.0.4844.84 Safari/537.36");

                CloseableHttpResponse execute = httpClient.execute(httpGet);
                byte[] vieoByte = EntityUtils.toByteArray(execute.getEntity());
                System.out.println(vieoByte.length);
                httpGet.setURI(URI.create(audio));
                CloseableHttpResponse execute1 = httpClient.execute(httpGet);
                byte[] audioByte = EntityUtils.toByteArray(execute1.getEntity());
                System.out.println(audioByte.length);
                bytemap.put("video", vieoByte);
                bytemap.put("audio", audioByte);
                i = false;
            } catch (ConnectionClosedException e) {
                i = true;
                System.out.println(e + "\n" + "网速问题，停止下载，重新下载。");
            } catch (Exception e) {
                e.printStackTrace();
            }
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

    //修改文件名中有带\的
    public String updataFile(String title) {
        if (title.indexOf("/") != -1) {
            title = title.replaceAll("/", "");
        }
        if (title.indexOf(":") != -1) {
            title = title.replaceAll(":", "-");
        }
        if (title.indexOf(" ") != -1) {
            title = title.replaceAll(" ", "");
        }
        System.out.println(title);
        return title;
    }
}

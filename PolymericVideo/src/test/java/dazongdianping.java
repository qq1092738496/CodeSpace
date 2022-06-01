import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * @author: Andy
 * @time: 2021/10/5 10:02
 */

public class dazongdianping {
    @Test
    public void test(){
        CloseableHttpClient clinet = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://www.dianping.com/shop/H3o5gcvPmfwZQyMU/review_all/p3?queryType=isAll&queryVal=true");
        httpGet.setHeader("Cookie", "fspop=test; _lx_utm=utm_source%3DBaidu%26utm_medium%3Dorganic; " +
                "_lxsdk_cuid=17c4dfcb2a4c8-05188436dc33e5-b7a1a38-1fa400-17c4dfcb2a4c8; " +
                "_lxsdk=17c4dfcb2a4c8-05188436dc33e5-b7a1a38-1fa400-17c4dfcb2a4c8; _hc" +
                ".v=9b9fa9e9-7695-fc14-912e-fd8a36e4034e.1633395979; " +
                "Hm_lvt_602b80cf8079ae6591966cc70a3940e7=1633395981; s_ViewType=10; cy=9; cye=chongqing; " +
                "ctu=a1dbe739ec8da5a33e960910c8e3aed0775f4d92f74b2e1c53ba4c8629234695; " +
                "dplet=0f9dd7eb5592ac7d3ea753d167ca1488; " +
                "dper" +
                "=396bb0bc914aa650a4e2d76f5e8234649e2b8b31f0d9dfac25bfa415da58a02c85169ed036154ac01fa6b0af51958bceca7bed1f36a0eda64d424a26b13aaf9df4d7b207ffc6ce9ba7f66b8835f02c821438b7bac9d8e437a9505d227c526c3d; ll=7fd06e815b796be3df069dec7836c3df; ua=dpuser_7602365716; uamo=13277379523; cityInfo=%7B%22cityId%22%3A9%2C%22cityName%22%3A%22%E9%87%8D%E5%BA%86%22%2C%22provinceId%22%3A0%2C%22parentCityId%22%3A0%2C%22cityOrderId%22%3A0%2C%22isActiveCity%22%3Afalse%2C%22cityEnName%22%3A%22chongqing%22%2C%22cityPyName%22%3Anull%2C%22cityAreaCode%22%3Anull%2C%22cityAbbrCode%22%3Anull%2C%22isOverseasCity%22%3Afalse%2C%22isScenery%22%3Afalse%2C%22TuanGouFlag%22%3A0%2C%22cityLevel%22%3A0%2C%22appHotLevel%22%3A0%2C%22gLat%22%3A0%2C%22gLng%22%3A0%2C%22directURL%22%3Anull%2C%22standardEnName%22%3Anull%7D; Hm_lpvt_602b80cf8079ae6591966cc70a3940e7=1633397429; _lxsdk_s=17c4e305585-a11-309-42d%7C%7C1");
        httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.61 Safari/537.36");
        httpGet.setHeader("Host", "www.dianping.com");
        httpGet.setHeader("Referer", "https://www.dianping.com/shop/H3o5gcvPmfwZQyMU/review_all/p2?queryType=isAll&queryVal=true");
        try {
            CloseableHttpResponse execute = clinet.execute(httpGet);
            HttpEntity entity = execute.getEntity();

            String html = EntityUtils.toString(entity);

            Document parse = Jsoup.parse(html);
            Elements head = parse.select("head link[rel='stylesheet']");
            String cssurl = "https:"+head.get(1).attr("href");
            HttpGet cssget = new HttpGet(cssurl);
            cssget.setHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.61 Safari/537.36");
            CloseableHttpResponse execute1 = clinet.execute(cssget);
            HttpEntity entity1 = execute1.getEntity();

            String css = EntityUtils.toString(entity1);
            String name = "qpkqek";


            Pattern compile = Pattern.compile("."+name+"\\{background:\\S* \\S*}");
            Matcher matcher = compile.matcher(css);
            String zx = null;
            if (matcher.find()){
                zx = matcher.group();
            }
            Pattern compile1 = Pattern.compile("-(\\d*).(\\d)");
            Matcher matcher1 = compile1.matcher(zx);
            String ll = "";
            while (matcher1.find()){
                String s = " "+Integer.valueOf(matcher1.group(1)).toString();
                ll+=s;
            }
            System.out.println(ll);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void aa(){
        String css = ".qpkql9{background:-196.0px -2284.0px;}.qpkom9{background:-406.0px -2164.0px;}" +
                ".qpkx5m{background:-84" +
                ".0px -12.0px;}";
        String name = "qpkom9";
        Pattern compile = Pattern.compile("."+name+"\\{background:\\S* \\S*}");
        Matcher matcher = compile.matcher(css);
        String zx = null;
        if (matcher.find()){
            zx = matcher.group();
        }
        System.out.println(zx);
        Pattern compile1 = Pattern.compile("-(\\d*).(\\d)");
        Matcher matcher1 = compile1.matcher(zx);
        String ll = "";
        while (matcher1.find()){
            String s = " "+Integer.valueOf(matcher1.group(1)).toString();
            ll+=s;
        }
        System.out.println(ll);

    }
}

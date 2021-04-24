package run;

import javafx.geometry.Pos;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @description:
 * @author: Andy
 * @time: 2020/10/25 22:33
 */

public class test {
    public static void main(String[] args) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("hhttps://account.dianping.com/account/ajax/checkRisk");
        List<BasicNameValuePair> pairs = new ArrayList<>();
        pairs.add(new BasicNameValuePair("mobileNo", "13277379523"));
        pairs.add(new BasicNameValuePair("uuid", "65463319-a10a-4d31-8ec4-bed2f69411e6"));
        pairs.add(new BasicNameValuePair("type", "304"));
        pairs.add(new BasicNameValuePair("countrycode", "86"));
        httpPost.addHeader("User-Agent:","Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Safari/537.36");
        httpPost.addHeader("Accept-Language","zh-CN,zh;q=0.9");
        httpPost.addHeader("Host","account.dianping.com");
        httpPost.addHeader("Referer","https://account.dianping.com/account/iframeLogin?callback=EasyLogin_frame_callback0&wide=false&protocol=https:&redir=http%3A%2F%2Fwww.dianping.com");
        httpPost.addHeader("Content-Language","zh-CN");
        httpPost.addHeader("Content-Type","application/json;charset=UTF-8");
        httpPost.addHeader("M-TraceId:","-7995304108825850335");
        httpPost.addHeader("M-SpanName","MobileVerifySendAjaxAction.execute");
        httpPost.addHeader("Cookie","fspop=test; _lxsdk_cuid=17560036c4dc8-0128c24c6569af-383e5509-1fa400-17560036c4db5; _lxsdk=17560036c4dc8-0128c24c6569af-383e5509-1fa400-17560036c4db5; _hc.v=aef3d7c8-26c0-fe41-aa04-38f18e20b427.1603633639; s_ViewType=10; cy=1; cye=shanghai; _dp.ac.v=52135b7b-2d5b-42c8-88f4-e0ba5b1b30fb; ctu=a1dbe739ec8da5a33e960910c8e3aed0f55f16a7fb8e0012056ccfcb4336acf2; ua=%E5%B0%8F%E5%88%98%E4%B8%8D%E5%9B%B0; _lx_utm=utm_source%3DBaidu%26utm_medium%3Dorganic; Hm_lvt_602b80cf8079ae6591966cc70a3940e7=1603633639,1603641734,1603831671; _lxsdk_s=1756bd12469-b87-0d8-4cd%7C%7C8; Hm_lpvt_602b80cf8079ae6591966cc70a3940e7=1603833030; lgtoken=0ee9910c0-da99-458b-86f7-508bc565630b");
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(pairs, "utf-8"));
            CloseableHttpResponse execute = client.execute(httpPost);
            StatusLine statusLine = execute.getStatusLine();
            System.out.println(statusLine.getReasonPhrase());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

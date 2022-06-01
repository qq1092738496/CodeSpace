import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @description:
 * @author: Andy
 * @time: 2022/3/27 21:17
 */

public class test3 {
    public static void main(String[] args) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://www.libvio.com/play/100268-1-1.html");
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.84 Safari/537.36");

        try {
             CloseableHttpResponse response = httpClient.execute(httpGet);
             HttpEntity httpEntity= response.getEntity();
            String html = EntityUtils.toString(httpEntity);
            System.out.println(html);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

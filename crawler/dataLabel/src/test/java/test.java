import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;

/**
 * @description:
 * @author: Andy
 * @time: 2021/5/7 16:08
 */

public class test {

    @Test
    public void test(){
        String url="https://lingting.mininglamp.com/asw/bz/api/part/getTransPartDetail";
        CloseableHttpClient client = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet("https://lingting.mininglamp.com/asw/bz/api/log/heartbeat?type=1&taskId=848");
        httpGet.setHeader("token","eyJhbGciOiJIUzUxMiJ9" +
                ".eyJzdWIiOiIxMTg1IiwiZXhwIjoxNjIyOTU0OTkwLCJpYXQiOjE2MjAzNjI5OTB9.tSxNrVAZyWLFE8MRBmheYepteP4w53CNHL4HQmn1teJEUaIBxPnfcj1sSwxlsYDtW9USSlWCp2JU8o9GN9vWfA; JSESSIONID=DE15593BAA8536A7F062307312163683");
        httpGet.setHeader("cookie","token=eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMTg1IiwiZXhwIjoxNjIyOTU0OTkwLCJpYXQiOjE2MjAzNjI5OTB9.tSxNrVAZyWLFE8MRBmheYepteP4w53CNHL4HQmn1teJEUaIBxPnfcj1sSwxlsYDtW9USSlWCp2JU8o9GN9vWfA; JSESSIONID=DE15593BAA8536A7F062307312163683");
        httpGet.setHeader("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.90 Safari/537.36");
        httpGet.setHeader("sec-ch-ua","\"Google Chrome\";v=\"89\", \"Chromium\";v=\"89\", \";Not A Brand\";v=\"99\"");
        httpGet.setHeader("authorization","eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMTg1IiwiZXhwIjoxNjIyOTU0OTkwLCJpYXQiOjE2MjAzNjI5OTB9.tSxNrVAZyWLFE8MRBmheYepteP4w53CNHL4HQmn1teJEUaIBxPnfcj1sSwxlsYDtW9USSlWCp2JU8o9GN9vWfA");
        httpGet.setHeader("type","1");
        httpGet.setHeader("taskId","848");
        httpGet.setHeader(":method","POST");
        httpGet.setHeader(":authority","lingting.mininglamp.com");
        httpGet.setHeader("accept","application/json, text/plain, */*");


        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("token","eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMTg1IiwiZXhwIjoxNjIyOTU0OTkwLCJpYXQiOjE2MjAzNjI5OTB9.tSxNrVAZyWLFE8MRBmheYepteP4w53CNHL4HQmn1teJEUaIBxPnfcj1sSwxlsYDtW9USSlWCp2JU8o9GN9vWfA; JSESSIONID=DE15593BAA8536A7F062307312163683");
        httpPost.setHeader("cookie","token=eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMTg1IiwiZXhwIjoxNjIyOTU0OTkwLCJpYXQiOjE2MjAzNjI5OTB9.tSxNrVAZyWLFE8MRBmheYepteP4w53CNHL4HQmn1teJEUaIBxPnfcj1sSwxlsYDtW9USSlWCp2JU8o9GN9vWfA; JSESSIONID=DE15593BAA8536A7F062307312163683");
        httpPost.setHeader("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.90 Safari/537.36");
        httpPost.setHeader("sec-ch-ua","\"Google Chrome\";v=\"89\", \"Chromium\";v=\"89\", \";Not A Brand\";v=\"99\"");
        httpPost.setHeader("authorization","eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMTg1IiwiZXhwIjoxNjIyOTU0OTkwLCJpYXQiOjE2MjAzNjI5OTB9.tSxNrVAZyWLFE8MRBmheYepteP4w53CNHL4HQmn1teJEUaIBxPnfcj1sSwxlsYDtW9USSlWCp2JU8o9GN9vWfA");
        httpPost.setHeader("partId","12807");
        httpPost.setHeader(":method","POST");
        httpPost.setHeader(":authority","lingting.mininglamp.com");
        httpPost.setHeader("accept","application/json, text/plain, */*");
        httpPost.setHeader(":path:","/asw/bz/api/part/getTransPartDetail");


        try {
            CloseableHttpResponse response = client.execute(httpGet);

            CloseableHttpResponse execute = client.execute(httpPost);
            HttpEntity entity = execute.getEntity();

            String s = EntityUtils.toString(entity,"utf-8");
            System.out.println(s);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

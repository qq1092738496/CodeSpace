package com.medititation.util;

import com.sun.deploy.util.ArrayUtil;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;

/**
 * @description:
 * @author: Andy
 * @time: 2022/5/1 13:08
 */

public class ImgOrByte {
    public static byte[] getImgByte(String imgurl){
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet("https://img.alicdn.com/imgextra/i4/196993935/O1CN01GToMXR1ewHGd6J09A_!!196993935.jpg");
        byte[] bytes = new byte[0];
        try {
            bytes = EntityUtils.toByteArray(client.execute(get).getEntity());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }
}

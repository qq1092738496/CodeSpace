package core;

import constant.Constant;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import util.FileUtil;
import util.LogUtils;

import java.io.BufferedInputStream;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: Andy
 * @time: 2022/2/1 20:06
 */
//https://dldir1.qq.com/qqfile/qq/PCQQ9.5.6/QQ9.5.6.28129.exe
public class Download {
    public static void main(String[] args) {
        download("https://im.qq.com/pcqq");
    }

    public static ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
    public static void download(String url) {
        //本地文件大小
        long locaFileLangth = FileUtil.getFileContentLength("F:\\Download\\dd.exe");

        CloseableHttpClient Client = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        get.setHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0.4692.99 Safari/537.36");

        try {
            CloseableHttpResponse execute = Client.execute(get);
            //下载文件的总大小
            long contentLength = execute.getEntity().getContentLength();
            //判断文件是否已下载过
            if (locaFileLangth >= contentLength){
                LogUtils.info("{}已下载完毕,无需重新下载", url );
                return;
            }
            //创建下载信息任务对象 
            DownloadInfoThread downloadInfoThread = new DownloadInfoThread(contentLength);
            scheduledExecutorService.scheduleAtFixedRate(downloadInfoThread,1,1, TimeUnit.SECONDS);

            InputStream inputStream = execute.getEntity().getContent();
            BufferedInputStream bis = new BufferedInputStream(inputStream);

            FileOutputStream ops = new FileOutputStream("F:\\Download\\"+"dd.exe");
            BufferedOutputStream bos = new BufferedOutputStream(ops);

            int len = -1;
            byte[] buffer = new byte[(int)(contentLength*0.2)];
            System.out.println((int)contentLength);
            while ((len=bis.read(buffer))!= -1){
                bos.write(buffer,0,len);
                downloadInfoThread.downSize += len;
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
            LogUtils.error("下载文件不存在{}",url);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.error("下载失败 ");
        }finally {
            System.out.print("\r");
            System.out.print("下载完成");
            scheduledExecutorService.shutdownNow();
        }
    }
}

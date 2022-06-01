package core;

import constant.Constant;

/**
 * @description:
 * @author: Andy
 * @time: 2022/2/2 14:14
 */
//展示下载信息当线程
public class DownloadInfoThread implements Runnable {
    //文件总大小
    private long httpFileContentLength;

    //本地已经下载文件当大小
    private double finishedSize;

    //前一次下载大小
    public double prevSize;

    //本次累计下载大小
    public volatile double downSize;

    public DownloadInfoThread(long httpFileContentLength) {
        this.httpFileContentLength = httpFileContentLength;
    }

    @Override
    public void run() {
        //计算文件的总大小mb
        String httpfileSize = String.format("%.2f", httpFileContentLength / Constant.MB);

        //计算每秒下载速度kb
        int speed = (int)((downSize - prevSize) / 1024d);
        prevSize = downSize;

        //剩余文件大小
        double remaininSize = httpFileContentLength - finishedSize - downSize ;

        //计算剩余时间
        String remaininTime = String.format("%.1f", remaininSize / 1024d / speed);
        if ("Infinity".equalsIgnoreCase(remaininTime)){
            remaininTime = "-";
        }

        //已下载大小
        String currentFileSize  = String.format("%.2f", (downSize - finishedSize) / Constant.MB);

        String DownInfo = String.format("已下载 %smb/%smb,速度 %skb/s,剩余时间%ss", currentFileSize, httpfileSize, speed,
                remaininTime);
        System.out.print("\r");
        System.out.print(DownInfo);
    }
}

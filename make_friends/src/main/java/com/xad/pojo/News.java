package com.xad.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description: 消息表
 * @author: Andy
 * @time: 2022/5/3 12:26
 */

public class News {
    private String newsNumber;  //编号
    private int Sort_Id;    //排序的id
    private String Sender;  //发送人
    private String Content; //内容
    private String Receiver;    //接受人
    private boolean Or_Read;    //已读或未读
    private String News_Time; //时间

    public News() {
    }

    public News(String NewsNumber, String sender, String content, String receiver, boolean or_Read,
                String news_Time) {
        newsNumber = NewsNumber;
        Sender = sender;
        Content = content;
        Receiver = receiver;
        Or_Read = or_Read;

        News_Time = news_Time;
    }

    public String getnewsNumber() {
        return newsNumber;
    }

    public void setNumber(String Number) {
        newsNumber = Number;
    }

    public int getSort_Id() {
        return Sort_Id;
    }

    public void setSort_Id(int sort_Id) {
        Sort_Id = sort_Id;
    }

    public String getSender() {
        return Sender;
    }

    public void setSender(String sender) {
        Sender = sender;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getReceiver() {
        return Receiver;
    }

    public void setReceiver(String receiver) {
        Receiver = receiver;
    }

    public boolean isOr_Read() {
        return Or_Read;
    }

    public void setOr_Read(boolean or_Read) {
        Or_Read = or_Read;
    }

    public String getNews_Time() {
        /*SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        News_Time = formatter.format(new Date().getTime());*/
        return News_Time;
    }

    @Override
    public String toString() {
        return "News{" +
                "newsNumber='" + newsNumber + '\'' +
                ", Sort_Id=" + Sort_Id +
                ", Sender='" + Sender + '\'' +
                ", Content='" + Content + '\'' +
                ", Receiver='" + Receiver + '\'' +
                ", Or_Read=" + Or_Read +
                ", News_Time='" + News_Time + '\'' +
                '}';
    }
}

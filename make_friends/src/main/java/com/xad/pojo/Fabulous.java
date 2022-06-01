package com.xad.pojo;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description: 点赞表
 * @author: Andy
 * @time: 2022/5/3 12:28
 */

public class Fabulous {
    private String Fabulous_Number;   //被点赞的消息编号
    private int Sort_Id;
    private String Fabulous_userName;  //点赞人
    private String Fabulous_Time;     //时间

    public Fabulous() {
    }

    public Fabulous(int sort_id, String fabulous_Number, String fabulous_userName) {
        Fabulous_Number = fabulous_Number;
        Sort_Id = sort_id;
        Fabulous_userName = fabulous_userName;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Fabulous_Time = formatter.format(new Date().getTime());
    }

    public int getSort_Id() {
        return Sort_Id;
    }

    public void setSort_Id(int sort_Id) {
        Sort_Id = sort_Id;
    }

    public String getFabulous_Number() {
        return Fabulous_Number;
    }

    public void setFabulous_Number(String fabulous_Number) {
        Fabulous_Number = fabulous_Number;
    }

    public String getFabulous_userName() {
        return Fabulous_userName;
    }

    public void setFabulous_userName(String fabulous_userName) {
        Fabulous_userName = fabulous_userName;
    }

    public String getFabulous_Time() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Fabulous_Time = formatter.format(new Date().getTime());
        return Fabulous_Time;
    }


    @Override
    public String toString() {
        return "Fabulous{" +
                "Fabulous_Number='" + Fabulous_Number + '\'' +
                ", Sort_Id=" + Sort_Id +
                ", Fabulous_userName='" + Fabulous_userName + '\'' +
                ", Fabulous_Time='" + Fabulous_Time + '\'' +
                '}';
    }
}

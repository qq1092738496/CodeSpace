package com.xad.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @description: 用户表
 * @author: Andy
 * @time: 2022/5/3 12:22
 */


public class User {

    private String userNumber; //用户编号 uuid
    private String userName;    //账号
    private String passWord;    //密码
    private String Name;    //姓名
    private String Mailbox; //邮箱
    private String Telephone; //电话
    private String WeChat; //微信
    private String nickName;    //昵称
    private byte[] Photo;   //头像img
    private boolean Gander; //性别
    private String Hobby; //爱好
    private int Height; //身高
    private int Weight; //体重
    private int Age;    //年龄
    private String Location;    //所在地
    private boolean Marriage;   //是否结婚
    private String Occupation;  //职业
    private String Registration_Time; //注册时间
    private String Brief_Introduction;  //个人简介

    public User() {
    }

    public User(String userNumber, String userName, String passWord, String name, String mailbox, String telephone,
                String weChat, String nickName, byte[] photo, boolean gander, String hobby, int height, int weight,
                int age, String location, boolean marriage, String occupation,
                String brief_Introduction,String registration_Time ) {
        this.userNumber = userNumber;
        this.userName = userName;
        this.passWord = passWord;
        Name = name;
        this.Mailbox = mailbox;
        Telephone = telephone;
        WeChat = weChat;
        this.nickName = nickName;
        Photo = photo;
        Gander = gander;
        Hobby = hobby;
        Height = height;
        Weight = weight;
        Age = age;
        Location = location;
        Marriage = marriage;
        Occupation = occupation;
        Registration_Time = registration_Time;
        Brief_Introduction = brief_Introduction;
    }

    public String getMailbox() {
        return Mailbox;
    }

    public void setMailbox(String mailbox) {
        this.Mailbox = mailbox;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public String getWeChat() {
        return WeChat;
    }

    public void setWeChat(String weChat) {
        WeChat = weChat;
    }

    public String getHobby() {
        return Hobby;
    }

    public void setHobby(String hobby) {
        Hobby = hobby;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public byte[] getPhoto() {
        return Photo;
    }

    public void setPhoto(byte[] photo) {
        Photo = photo;
    }

    public boolean getGander() {
        return Gander;
    }

    public void setGander(boolean gander) {
        Gander = gander;
    }

    public int getHeight() {
        return Height;
    }

    public void setHeight(int height) {
        Height = height;
    }

    public int getWeight() {
        return Weight;
    }

    public void setWeight(int weight) {
        Weight = weight;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public boolean isMarriage() {
        return Marriage;
    }

    public void setMarriage(boolean marriage) {
        Marriage = marriage;
    }

    public String getOccupation() {
        return Occupation;
    }

    public void setOccupation(String occupation) {
        Occupation = occupation;
    }

    public String getRegistration_Time() {

        return Registration_Time;
    }

    public String getBrief_Introduction() {
        return Brief_Introduction;
    }

    public void setBrief_Introduction(String brief_Introduction) {
        Brief_Introduction = brief_Introduction;
    }

    @Override
    public String toString() {
        return "User{" +
                "userNumber='" + userNumber + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", Name='" + Name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", Photo=" + Arrays.toString(Photo) +
                ", Gander=" + Gander +
                ", Hobby='" + Hobby + '\'' +
                ", Height=" + Height +
                ", Weight=" + Weight +
                ", Age=" + Age +
                ", Location='" + Location + '\'' +
                ", Marriage=" + Marriage +
                ", Occupation='" + Occupation + '\'' +
                ", Registration_Time='" + Registration_Time + '\'' +
                ", Brief_Introduction='" + Brief_Introduction + '\'' +
                '}';
    }
}

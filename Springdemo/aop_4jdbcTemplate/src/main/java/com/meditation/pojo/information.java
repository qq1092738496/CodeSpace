package com.meditation.pojo;

import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Andy
 * @time: 2020/7/10 1:03
 */

@Component
public class information {
    private int id;
    private String title;
    private String companyName;
    private String companymessage;
    private String education;
    private String time;
    private String site;
    private String money;
    private String workmessage;
    private String url;
    private String source;

    public information() {
    }

    public information(int id, String title, String companyName, String companymessage, String education, String time
            , String site, String money, String workmessage, String url, String source) {
        this.id = id;
        this.title = title;
        this.companyName = companyName;
        this.companymessage = companymessage;
        this.education = education;
        this.time = time;
        this.site = site;
        this.money = money;
        this.workmessage = workmessage;
        this.url = url;
        this.source = source;
    }

    @Override
    public String toString() {
        return "information{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companymessage='" + companymessage + '\'' +
                ", education='" + education + '\'' +
                ", time='" + time + '\'' +
                ", site='" + site + '\'' +
                ", money='" + money + '\'' +
                ", workmessage='" + workmessage + '\'' +
                ", url='" + url + '\'' +
                ", source='" + source + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanymessage() {
        return companymessage;
    }

    public void setCompanymessage(String companymessage) {
        this.companymessage = companymessage;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getWorkmessage() {
        return workmessage;
    }

    public void setWorkmessage(String workmessage) {
        this.workmessage = workmessage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}

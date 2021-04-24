package com.meditation.pojo;

public class message {
    private String Title;
    private String CompanyName;
    private String Companymessage;
    private String Education;
    private String Time;
    private String Site;
    private String Money;
    private String Workmessage;
    private String Url;
    private String Source;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getCompanymessage() {
        return Companymessage;
    }

    public void setCompanymessage(String companymessage) {
        Companymessage = companymessage;
    }

    public String getEducation() {
        return Education;
    }

    public void setEducation(String education) {
        Education = education;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getSite() {
        return Site;
    }

    public void setSite(String site) {
        Site = site;
    }

    public String getMoney() {
        return Money;
    }

    public void setMoney(String money) {
        Money = money;
    }

    public String getWorkmessage() {
        return Workmessage;
    }

    public void setWorkmessage(String workmessage) {
        Workmessage = workmessage;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public message() {
    }

    public message(String title, String companyName, String companymessage, String education, String time, String site, String money, String workmessage, String url, String source) {
        Title = title;
        CompanyName = companyName;
        Companymessage = companymessage;
        Education = education;
        Time = time;
        Site = site;
        Money = money;
        Workmessage = workmessage;
        Url = url;
        Source = source;
    }

    @Override
    public String toString() {
        return "message{" +
                "Title='" + Title + '\'' +
                ", CompanyName='" + CompanyName + '\'' +
                ", Companymessage='" + Companymessage + '\'' +
                ", Education='" + Education + '\'' +
                ", Time='" + Time + '\'' +
                ", Site='" + Site + '\'' +
                ", Money='" + Money + '\'' +
                ", Workmessage='" + Workmessage + '\'' +
                ", Url='" + Url + '\'' +
                ", Source='" + Source + '\'' +
                '}';
    }
}

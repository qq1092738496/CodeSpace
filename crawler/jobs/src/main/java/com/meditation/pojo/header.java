package com.meditation.pojo;

public class header {
    private String userAgent;
    private String cookie;
    private String url;

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public String getCookie() {
        return cookie;
    }

    public String getUrl() {
        return url;
    }
}

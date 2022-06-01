package com.xad.pojo;

import java.util.LinkedList;

/**
 * @description:
 * @author: Andy
 * @time: 2022/5/9 21:42
 */

public class NewsPage {
    private Integer thisPage; // 当前页数
    private Integer pageSize;  //页面大小,每页显示多少数据
    private LinkedList<News> limitNews; //查询结果
    private Integer totalNews;  //数据总数
    private Integer totalPage;  //共有多少页

    public NewsPage() {
    }

    public NewsPage(Integer thisPage, Integer pageSize, LinkedList<News> limitNews, Integer totalNews,
                    Integer totalPage) {
        this.thisPage = thisPage;
        this.pageSize = pageSize;
        this.limitNews = limitNews;
        this.totalNews = totalNews;
        this.totalPage = totalPage;
    }

    public Integer getThisPage() {
        return thisPage;
    }

    public void setThisPage(Integer thisPage) {
        this.thisPage = thisPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public LinkedList<News> getLimitNews() {
        return limitNews;
    }

    public void setLimitNews(LinkedList<News> limitNews) {
        this.limitNews = limitNews;
    }

    public Integer getTotalNews() {
        return totalNews;
    }

    public void setTotalNews(Integer totalNews) {
        this.totalNews = totalNews;
    }

    public Integer getTotalPage() {
        this.totalPage = 0;
        if (null != totalNews & null != pageSize) {
            this.totalPage = this.totalNews % this.pageSize == 0 ? this.totalNews / this.pageSize :
                    this.totalNews / this.pageSize + 1;
        }
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public String toString() {
        return "NewsPage{" +
                "thisPage=" + thisPage +
                ", pageSize=" + pageSize +
                ", limitNews=" + limitNews +
                ", totalNews=" + totalNews +
                ", totalPage=" + totalPage +
                '}';
    }
}

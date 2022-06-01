package com.xad.pojo;

import java.util.LinkedList;

/**
 * @description:
 * @author: Andy
 * @time: 2022/5/9 21:07
 */

public class UserPage {
    private Integer thisPage; // 当前页数
    private Integer pageSize;  //页面大小,每页显示多少数据
    private LinkedList<User> limitUser; //查询结果
    private Integer totalUser;  //数据总数
    private Integer totalPage;  //共有多少页

    public UserPage() {
    }

    public UserPage(Integer thisPage, Integer pageSize, LinkedList<User> limitUser, Integer totalUser,
                    Integer totalPage) {
        this.thisPage = thisPage;
        this.pageSize = pageSize;
        this.limitUser = limitUser;
        this.totalUser = totalUser;
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

    public LinkedList<User> getLimitUser() {
        return limitUser;
    }

    public void setLimitUser(LinkedList<User> limitUser) {
        this.limitUser = limitUser;
    }

    public Integer getTotalUser() {
        return totalUser;
    }

    public void setTotalUser(Integer totalUser) {
        this.totalUser = totalUser;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalPage() {
        this.totalPage = 0;
        if (null != totalUser & null != pageSize) {
            this.totalPage = this.totalUser % this.pageSize == 0 ? this.totalUser / this.pageSize :
                    this.totalUser / this.pageSize + 1;
        }
        return totalPage;
    }

    @Override
    public String toString() {
        return "UserPage{" +
                "thisPage=" + thisPage +
                ", pageSize=" + pageSize +
                ", limitUser=" + limitUser +
                ", totalUser=" + totalUser +
                ", totalPage=" + totalPage +
                '}';
    }
}

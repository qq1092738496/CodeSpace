package com.meditation.pojo;

import java.util.List;

public class user {
    private String name;
    private String age;
    private String hobby;
    private List<books> book;


    public user() {

    }

    public user(String name, String age, String hobby, List<books> book) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
        this.book = book;
    }

    public user(List<books> book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "user{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", hobby='" + hobby + '\'' +
                ", book=" + book +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public List<books> getBook() {
        return book;
    }

    public void setBook(List<books> book) {
        this.book = book;
    }
}

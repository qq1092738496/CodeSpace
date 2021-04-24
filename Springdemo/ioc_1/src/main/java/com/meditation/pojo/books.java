package com.meditation.pojo;

public class books {
    private Integer id;
    private String name;
    private String author;

    public books(Integer id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public books() {
    }

    @Override
    public String toString() {
        return "books{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

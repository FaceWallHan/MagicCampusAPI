package com.hss.campus.entity;

import java.util.Date;

public class Announcement {
    private Integer a_id;
    private Integer id;
    private String author;
    private String content;
    private String title;
    private String image;
    private String time;

    public Announcement() {
    }

    public Announcement(Integer a_id, Integer id, String author, String content, String title, String image, String time) {
        this.a_id = a_id;
        this.id = id;
        this.author = author;
        this.content = content;
        this.title = title;
        this.image = image;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "a_id=" + a_id +
                ", id=" + id +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public Integer getA_id() {
        return a_id;
    }

    public void setA_id(Integer a_id) {
        this.a_id = a_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

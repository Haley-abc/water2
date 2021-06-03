package com.example.water11.data.service;

public class Knowledge {
    private String title;
    private String content;
    private String address;
    private int picture;
    private int times;

    public Knowledge(String title, String content, String address, int picture, int times) {
        this.title = title;
        this.content = content;
        this.address = address;
        this.picture = picture;
        this.times = times;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }
}

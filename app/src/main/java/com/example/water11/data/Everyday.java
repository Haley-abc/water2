package com.example.water11.data;

import org.litepal.crud.DataSupport;

public class Everyday extends DataSupport{
    private int id;
    private String date;//日期
    private int waterSaving;//当天节水量
    private int signIn;//是否签到
    private User user;//和user关联

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getSignIn() {
        return signIn;
    }

    public void setSignIn(int signIn) {
        this.signIn = signIn;
    }

    public int getWaterSaving() {
        return waterSaving;
    }

    public void setWaterSaving(int waterSaving) {
        this.waterSaving = waterSaving;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

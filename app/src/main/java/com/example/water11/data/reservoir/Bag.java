package com.example.water11.data.reservoir;

import com.example.water11.data.User;

import org.litepal.crud.DataSupport;

public class Bag extends DataSupport {
    private int id;
    private User user;
    private int primaryCleaner;//初级清洁工
    private int intermediateCleaner;//中级清洁工
    private int seniorCleaner;//高级清洁工
    private int superCleaner;//特级清洁工
    private int fish;//鱼
    private int waterLilies;//睡莲
    private int waterNum;//水量

    public Bag(){
        primaryCleaner=0;
        intermediateCleaner=0;
        seniorCleaner=0;
        superCleaner=0;
        fish=0;
        waterLilies=0;
        waterNum=0;
    }

    public int getWaterNum() {
        return waterNum;
    }

    public void setWaterNum(int waterNum) {
        this.waterNum = waterNum;
    }

    public int getPrimaryCleaner() {
        return primaryCleaner;
    }

    public void setPrimaryCleaner(int primaryCleaner) {
        this.primaryCleaner = primaryCleaner;
    }

    public int getIntermediateCleaner() {
        return intermediateCleaner;
    }

    public void setIntermediateCleaner(int intermediateCleaner) {
        this.intermediateCleaner = intermediateCleaner;
    }

    public int getSeniorCleaner() {
        return seniorCleaner;
    }

    public void setSeniorCleaner(int seniorCleaner) {
        this.seniorCleaner = seniorCleaner;
    }

    public int getSuperCleaner() {
        return superCleaner;
    }

    public void setSuperCleaner(int superCleaner) {
        this.superCleaner = superCleaner;
    }

    public int getFish() {
        return fish;
    }

    public void setFish(int fish) {
        this.fish = fish;
    }

    public int getWaterLilies() {
        return waterLilies;
    }

    public void setWaterLilies(int waterLilies) {
        this.waterLilies = waterLilies;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

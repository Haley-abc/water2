package com.example.water11.data;

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class User extends DataSupport {
    private int id;
    private String account;//账号
    private String password;//密码
    private String nickName;//昵称
    private int level;//等级
    private int coin;//积分
    private int days;//签到天数
    private String date;//上次签到日期
    private int reservoirDays;//水库经验增加天数
    private String reservoirDate;//水库经验增加日期
    private String refreshDate;//水库刷新日期
    private List<Bag> bags=new ArrayList<Bag>();//水库背包物品
    private int polutionNum;//污染物个数
    private int fishNum;//鱼个数
    private int kitNum;//工具箱个数

    public int getKitNum() {
        return kitNum;
    }

    public void setKitNum(int kitNum) {
        this.kitNum = kitNum;
    }

    public int getFishNum() {
        return fishNum;
    }

    public void setFishNum(int fishNum) {
        this.fishNum = fishNum;
    }

    public int getPolutionNum() {
        return polutionNum;
    }

    public void setPolutionNum(int polutionNum) {
        this.polutionNum = polutionNum;
    }

    public String getRefreshDate() {
        return refreshDate;
    }

    public void setRefreshDate(String refreshDate) {
        this.refreshDate = refreshDate;
    }

    public List<Bag> getBags() {
        return bags;
    }

    public void setBags(List<Bag> bags) {
        this.bags = bags;
    }

    public String getReservoirDate() {
        return reservoirDate;
    }

    public void setReservoirDate(String reservoirDate) {
        this.reservoirDate = reservoirDate;
    }

    private List<Everyday> everydays=new ArrayList<Everyday>();

    public int getReservoirDays() {
        return reservoirDays;
    }

    public void setReservoirDays(int reservoirDays) {
        this.reservoirDays = reservoirDays;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Everyday> getEverydays() {
        return everydays;
    }

    public void setEverydays(List<Everyday> everydays) {
        this.everydays = everydays;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getNickName() {
        return nickName;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

package com.example.water11.data.reservoir;

import com.example.water11.data.User;

import org.litepal.crud.DataSupport;

public class Game extends DataSupport {
        private int id;//水库id
        private User user;//和user表关联
        private int waterQuantity;//水量
        private int coinNum;//金币数
        private int fishNum;//水生生物数量
        private int kitNum;//工具数量
        private int polutionNum;//污染物数量
        private int days;//累计签到日期
        private String date;//上次签到日期

    public Game(){
        waterQuantity=0;
        coinNum=0;
        fishNum=0;
        kitNum=0;
        polutionNum=0;
        days=0;
        date="0000-00-00";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getDays() {
            return days;
        }

        public void setDays(int days) {
            this.days = days;
        }

        public int getPolutionNum() {
            return polutionNum;
        }

        public void setPolutionNum(int polutionNum) {
            this.polutionNum = polutionNum;
        }

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

        public int getCoinNum() {
            return coinNum;
        }

        public void setCoinNum(int coinNum) {
            this.coinNum = coinNum;
        }

        public int getWaterQuantity() {
            return waterQuantity;
        }

        public void setWaterQuantity(int waterQuantity) {
            this.waterQuantity = waterQuantity;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

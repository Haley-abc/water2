package com.example.water11.data.shop;

public class Goods {
    private String name;
    private int imageId;
    private int num;

    public Goods(String name, int imageId, int num) {
        this.name = name;
        this.imageId = imageId;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

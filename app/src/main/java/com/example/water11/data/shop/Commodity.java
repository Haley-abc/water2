package com.example.water11.data.shop;

public class Commodity {
    private String name;
    private double price;
    private int imageId;
    public Commodity(String name,double price,int imageId){
        this.name=name;
        this.price=price;
        this.imageId=imageId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

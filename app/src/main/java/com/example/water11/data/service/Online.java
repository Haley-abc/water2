package com.example.water11.data.service;

public class Online {
    private String tille;
    private String content;

    public Online(String tille, String content) {
        this.tille = tille;
        this.content = content;
    }

    public String getTille() {
        return tille;
    }

    public void setTille(String tille) {
        this.tille = tille;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

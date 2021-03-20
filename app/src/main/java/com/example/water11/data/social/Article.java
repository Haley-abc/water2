package com.example.water11.data.social;

import org.litepal.crud.DataSupport;

public class Article extends DataSupport {
    private int userHeadId;
    private String name;
    private String content;
    private int userPictureId;

    public Article(int userHeadId,String name,String content,int userPictureId){
        this.userHeadId=userHeadId;
        this.name=name;
        this.content=content;
        this.userPictureId=userPictureId;
    }
    public Article(){

    }

    public int getUserHeadId() {
        return userHeadId;
    }
    public void setUserHeadId(int userHeadId) {
        this.userHeadId=userHeadId;
    }

    public int getUserPictureId() {
        return userPictureId;
    }
    public void setUserPictureId(int userPictureId){this.userPictureId=userPictureId;}

    public String getContent() {
        return content;
    }
    public void setContent(String content){this.content=content;}

    public String getName() {
        return name;
    }
    public void setName(String name){this.name=name;}
}

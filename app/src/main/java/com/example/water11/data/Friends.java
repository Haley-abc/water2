package com.example.water11.data;

import java.util.ArrayList;
import java.util.List;

public class Friends {
    private List<User> friends=new ArrayList<User>();

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }
}

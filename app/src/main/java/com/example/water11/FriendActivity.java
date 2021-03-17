package com.example.water11;

import android.os.Bundle;

import com.example.water11.tool.BaseActivity;

public class FriendActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }//去掉默认菜单栏
    }
}

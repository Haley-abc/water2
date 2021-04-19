package com.example.water11.ui.Service.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.water11.R;

public class UnderlineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_underline);

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }//去掉默认菜单栏
    }
}

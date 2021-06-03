package com.example.water11.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.water11.R;

public class RepairActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repair);


        /*隐藏顶部默认菜单栏*/
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
    }
}

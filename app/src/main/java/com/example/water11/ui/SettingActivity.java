package com.example.water11.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.water11.R;
import com.example.water11.data.User;
import com.example.water11.tool.MySharedPreferences;

import org.litepal.crud.DataSupport;

public class SettingActivity extends AppCompatActivity {

    private TextView tvSettingName;
    private int id;
    private User user;
    private LinearLayout llRepairService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        id=(int) MySharedPreferences.getId(this);
        user= DataSupport.find(User.class,id,true);

        llRepairService=findViewById(R.id.ll_repair_service);
        String name=user.getNickName();

        tvSettingName=(TextView)findViewById(R.id.tv_setting_name);
        tvSettingName.setText(name);

        llRepairService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SettingActivity.this,RepairActivity.class);
                startActivity(intent);
            }
        });

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }//去掉默认菜单栏
    }
}

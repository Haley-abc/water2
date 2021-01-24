package com.example.water11;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.water11.data.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import org.litepal.crud.DataSupport;

public class MainActivity extends AppCompatActivity{
    TextView nickName;
    TextView grade;
    TextView coinNumber;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent=getIntent();
        id=intent.getIntExtra("id",0);
        User user=DataSupport.find(User.class,id);//LoginActivity传来id数据

        nickName = (TextView) findViewById(R.id.tv_nick_name);
        nickName.setText(user.getNickName());//显示昵称

        grade=(TextView)findViewById(R.id.tv_grade);
        grade.setText(String.valueOf(user.getLevel()));//显示等级（grade）

        coinNumber=(TextView)findViewById(R.id.tv_coin_number);
        coinNumber.setText(String.valueOf(user.getCoin()));//显示金币数(coin)

        /*底部按钮*/
        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications,R.id.navigation_service,R.id.navigation_reservoir)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);


        /*隐藏顶部默认菜单栏*/
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
    }

    /*返回登录者id*/
    public int getId(){
        return this.id;
    }
}

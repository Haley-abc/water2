package com.example.water11;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.water11.data.User;
import com.example.water11.tool.ActivityCollector;
import com.example.water11.tool.BaseActivity;
import com.example.water11.tool.MySharedPreferences;
import com.example.water11.ui.Reservoir.ReservoirFragment;
import com.example.water11.ui.SettingActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import org.litepal.crud.DataSupport;

public class MainActivity extends BaseActivity {
    TextView nickName;
    TextView grade;
    TextView coinNumber;
    int id;
    String account;
    Button btPersonalCenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //查看是否有本地扥估记录
        id=(int) MySharedPreferences.getId(MainActivity.this);
        account=(String)MySharedPreferences.getName(MainActivity.this);
        if(account==null||account.length()==0){
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }//没有记录则返回登录界面

        User user=DataSupport.find(User.class,id);//LoginActivity传来id数据

        nickName = (TextView) findViewById(R.id.tv_nick_name);
        nickName.setText(user.getNickName());//显示昵称

        grade=(TextView)findViewById(R.id.tv_grade);
        grade.setText(String.valueOf(user.getLevel()));//显示等级（grade）

        coinNumber=(TextView)findViewById(R.id.tv_coin_number);
        coinNumber.setText(String.valueOf(user.getCoin()));//显示金币数(coin)

        btPersonalCenter=(Button)findViewById(R.id.bt_personal_center);
        btPersonalCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(btPersonalCenter);
            }
        });

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

    //点击返回销毁所有活动
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ActivityCollector.finishAll();
    }

    //顶部菜单
    private void showPopupMenu(View view) {
        // View当前PopupMenu显示的相对View的位置
        PopupMenu popupMenu = new PopupMenu(this, view);
        // menu布局
        popupMenu.getMenuInflater().inflate(R.menu.top_menu, popupMenu.getMenu());
        // menu的item点击事件
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                //Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
               switch (item.getItemId()){
                   case R.id.back_to_login:
                       Intent intent1=new Intent(MainActivity.this,LoginActivity.class);
                       startActivity(intent1);
                   case R.id.setting:
                       Intent intent2=new Intent(MainActivity.this, SettingActivity.class);
                       startActivity(intent2);
               }
                return false;
            }
        });
        /*PopupMenu关闭事件
        popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
            @Override
            public void onDismiss(PopupMenu menu) {
                Toast.makeText(getApplicationContext(), "关闭PopupMenu", Toast.LENGTH_SHORT).show();
            }
        });*/

        popupMenu.show();
    }
}

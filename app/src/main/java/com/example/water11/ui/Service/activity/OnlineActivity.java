package com.example.water11.ui.Service.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.water11.R;
import com.example.water11.data.service.Online;
import com.example.water11.data.service.OnlineAdapter;

import java.util.ArrayList;
import java.util.List;

public class OnlineActivity extends AppCompatActivity {
    private List<Online> onlineList=new ArrayList<Online>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online);

        initOnline();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.online_activity_list);
        LinearLayoutManager layoutManager=new LinearLayoutManager(OnlineActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        OnlineAdapter adapter=new OnlineAdapter(onlineList);
        recyclerView.setAdapter(adapter);

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }//去掉默认菜单栏
    }

    public void initOnline(){
        Online online=new Online("中国水周","省水科院开展“世界水日”“中国水周”宣传进校园活动");
        onlineList.add(online);
    }

}

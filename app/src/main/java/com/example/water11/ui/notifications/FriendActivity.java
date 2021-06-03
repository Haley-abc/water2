package com.example.water11.ui.notifications;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.water11.R;
import com.example.water11.data.User;
import com.example.water11.data.UserAdapter;
import com.example.water11.tool.BaseActivity;
import com.example.water11.tool.MySharedPreferences;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class FriendActivity extends BaseActivity {

    private List<User> userList=new ArrayList<User>();
    private int id;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);

        id=(int) MySharedPreferences.getId(this);
        user= DataSupport.find(User.class,id,true);

        initFriends();
        RecyclerView friendsRecyclerView=(RecyclerView)findViewById(R.id.friends_list);
        LinearLayoutManager layoutManager=new LinearLayoutManager(FriendActivity.this);
        friendsRecyclerView.setLayoutManager(layoutManager);
        UserAdapter adapter=new UserAdapter(userList);
        friendsRecyclerView.setAdapter(adapter);

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }//去掉默认菜单栏
    }

    public void initFriends(){
        userList=DataSupport.findAll(User.class);
    }
}

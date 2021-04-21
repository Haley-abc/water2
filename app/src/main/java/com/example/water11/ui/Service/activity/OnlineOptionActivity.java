package com.example.water11.ui.Service.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.water11.R;
import com.example.water11.ui.WebActivity;

public class OnlineOptionActivity extends AppCompatActivity {

    private Button btSignUp;
    private Button btWalkInto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        btSignUp=(Button)findViewById(R.id.bt_sign_up);
        btWalkInto=(Button)findViewById(R.id.bt_walk_into);

        btWalkInto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OnlineOptionActivity.this, WebActivity.class);
                intent.putExtra("address","https://baijiahao.baidu.com/s?id=1696462447333890490&wfr=spider&for=pc");
                startActivity(intent);
            }
        });
        btSignUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OnlineOptionActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }//去掉默认菜单栏
    }
}

package com.example.water11;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.water11.data.User;
import com.example.water11.tool.ActivityCollector;
import com.example.water11.tool.BaseActivity;
import com.example.water11.tool.MySharedPreferences;

import org.litepal.crud.DataSupport;

import java.util.List;

public class LoginActivity extends BaseActivity {
    private EditText etAccount;
    private EditText etPassword;
    String account;
    String password;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etAccount=(EditText)findViewById(R.id.et_account);
        etPassword=(EditText)findViewById(R.id.et_password);

        /*
        得到本地的上次登录的账号密码，并登录，直接跳转MainActivity

        id=(int)MySharedPreferences.getId(LoginActivity.this);
        account=(String)MySharedPreferences.getName(LoginActivity.this);
        if(account!=null&&account.length()!=0){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra("id",id);
            startActivity(intent);
        }
*/
        Button btLogin=(Button)findViewById(R.id.bt_login);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                account=etAccount.getText().toString();
                password=etPassword.getText().toString();
                if(TextUtils.isEmpty(account)||TextUtils.isEmpty(password)){
                    Toast.makeText(LoginActivity.this,"输入不能为空", Toast.LENGTH_SHORT).show();
                }else {
                    List<User> users = DataSupport.where("account=?", account).find(User.class);
                    if(users.size()!=0) {
                        for (User user : users) {
                            if (user.getPassword().equals(password)) {
                                /*
                                本地保存登录信息
                                 */
                                id=user.getId();
                                Boolean bool= MySharedPreferences.setName(user.getAccount(),LoginActivity.this);//判断是否保存成功
                                MySharedPreferences.setPswd(user.getPassword(),LoginActivity.this);
                                MySharedPreferences.setId(user.getId(),LoginActivity.this);

                                if(bool){
                                    Toast.makeText(LoginActivity.this, "登录成功！", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    intent.putExtra("id",id);
                                    startActivity(intent);
                                }
                                else
                                    Toast.makeText(LoginActivity.this, "登录失败！", Toast.LENGTH_SHORT).show();

                            } else {
                                    Toast.makeText(LoginActivity.this, "密码输入错误", Toast.LENGTH_SHORT).show();
                                }
                        }
                    }else {
                        Toast.makeText(LoginActivity.this, "账号不存在", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        /*
        点击注册按钮，跳转到注册页面
         */
        Button btRegisterAccount=(Button)findViewById(R.id.bt_register_account);
        btRegisterAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        /*
        点击关于水按钮
         */
        Button btAboutWater=(Button)findViewById(R.id.bt_about_water);
        btAboutWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }//去掉默认菜单栏
    }

    //点击返回销毁所有活动
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ActivityCollector.finishAll();
    }
}

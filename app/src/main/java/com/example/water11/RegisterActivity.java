package com.example.water11;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.water11.data.Bag;
import com.example.water11.data.Everyday;
import com.example.water11.data.Reservoir;
import com.example.water11.data.User;

import org.litepal.crud.DataSupport;
import org.litepal.util.Const;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    private EditText etAccountRegister;//账号EditText
    private EditText etPasswordRegister;//密码EditText
    private EditText etNickName;//昵称EditText
    private EditText etPassword2;//再次输入密码EditText
    String account;
    String password;
    String nickName;
    String password2;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        /**
         * 去掉默认菜单栏
         */
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        etAccountRegister=(EditText)findViewById(R.id.et_account_register);
        etPasswordRegister=(EditText)findViewById(R.id.et_password_register);
        etNickName=(EditText)findViewById(R.id.et_nickname_register);
        etPassword2=(EditText)findViewById(R.id.et_password2_register);

        Button btRegister=(Button)findViewById(R.id.bt_register);
        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                account=etAccountRegister.getText().toString();
                password=etPasswordRegister.getText().toString();
                nickName=etNickName.getText().toString();
                password2=etPassword2.getText().toString();
                if(TextUtils.isEmpty(account)||TextUtils.isEmpty(password)||TextUtils.isEmpty(nickName)||TextUtils.isEmpty(password2)){
                    Toast.makeText(RegisterActivity.this,"输入不能为空", Toast.LENGTH_SHORT).show();
                }else {
                    List<User> users = DataSupport.where("account=?", account).find(User.class);
                    if(users.size()==0){
                        if (password.equals(password2)) {
                            Everyday everyday=new Everyday();
                            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
                            Date date = new Date(System.currentTimeMillis());
                            String day=formatter.format(date);

                            everyday.setWaterSaving(0);
                            everyday.setSignIn(0);
                            everyday.setDate(day);
                            everyday.save();

                            User user = new User();
                            user.setLevel(0);
                            user.setCoin(0);
                            user.setDays(0);
                            user.setDate("0-0-0");
                            user.setReservoirDate("0-0-0");
                            user.setReservoirDays(0);
                            user.setPolutionNum(0);
                            user.setKitNum(0);
                            user.setFishNum(0);
                            user.setRefreshDate("0-0-0");
                            user.setNickName(nickName);
                            user.setPassword(password);
                            user.setAccount(account);
                            user.getEverydays().add(everyday);
                            user.save();
                            if(user.save()) {
                                showDialog();
                            }
                            else{
                                Toast.makeText(RegisterActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(RegisterActivity.this, "两次输入密码不一致，请重新输入", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else Toast.makeText(RegisterActivity.this, "该账号已被注册，请重新输入", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void showDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("提示");
        builder.setMessage("注册成功！");
        builder.setPositiveButton("OK",
                new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        AlertDialog dialog=builder.create();
        dialog.show();
    }
}

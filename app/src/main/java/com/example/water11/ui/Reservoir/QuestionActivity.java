package com.example.water11.ui.Reservoir;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.water11.MainActivity;
import com.example.water11.R;
import com.example.water11.data.User;
import com.example.water11.data.reservoir.Game;
import com.example.water11.data.reservoir.Questions;
import com.example.water11.tool.MySharedPreferences;

import org.litepal.crud.DataSupport;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class QuestionActivity extends AppCompatActivity {
    private RadioButton A,B,C,D;
    private List<RadioButton> radioButtons;
    private Button btSure;
    private String[] question;
    private TextView tvTopic;
    private User user;
    private int id;
    private Game game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        id=(int) MySharedPreferences.getId(QuestionActivity.this);
        user= DataSupport.find(User.class,id,true);
        game=user.getGame();

        A=(RadioButton)findViewById(R.id.A);
        B=(RadioButton)findViewById(R.id.B);
        C=(RadioButton)findViewById(R.id.C);
        D=(RadioButton)findViewById(R.id.D);
        radioButtons=new ArrayList<RadioButton>();
        tvTopic=(TextView)findViewById(R.id.tv_topic);
        btSure=(Button)findViewById(R.id.bt_sure);

        question=AnswerQuestions.getQuestion();
        tvTopic.setText(question[0]);
        A.setText(question[1]);
        B.setText(question[2]);
        C.setText(question[3]);
        D.setText(question[4]);
        radioButtons.add(A);
        radioButtons.add(B);
        radioButtons.add(C);
        radioButtons.add(D);

        btSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isChoosen=false;
                for(RadioButton button:radioButtons){
                    if(button.isChecked()){
                        isChoosen=true;
                        showDialog(button.getText().toString().equals(question[5]));
                    }
                }
                if(isChoosen==false){
                    Toast.makeText(getApplicationContext(),"请选择答案",Toast.LENGTH_SHORT).show();
                }
            }
        });

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }//去掉默认菜单栏
    }

    private void showDialog(boolean isRight){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String day=formatter.format(date);

        ContentValues values=new ContentValues();
        values.put("answerDate",day);
        DataSupport.update(Game.class,values,game.getId());

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("提示");
        if(isRight){
            builder.setMessage("回答正确，金币+50");
            ContentValues values2=new ContentValues();
            int coinNum=game.getCoinNum()+20;
            values.put("coinNum",coinNum);
            DataSupport.update(Game.class,values,game.getId());
            builder.setPositiveButton("确认",
                    new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent=new Intent(QuestionActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    });
        }else{
            builder.setMessage("回答错误");
            builder.setPositiveButton("确认",
                    new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent=new Intent(QuestionActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    });
        }
        AlertDialog dialog=builder.create();
        dialog.show();
    }
}
class AnswerQuestions{
    public static String[] getQuestion(){
        String[] question=new String[6];
        List<Questions> questionList = DataSupport.findAll(Questions.class);
        int num=questionList.size();
        Random random=new Random();
        int questionIndex=random.nextInt(num);

        question[0]=questionList.get(questionIndex).getTopic();
        question[5]=questionList.get(questionIndex).getAnswer();

        Set<Integer> set = new HashSet<Integer>();
        int[] indexs=new int[4];
        for(int i=0;i<4;i++){
            int index=random.nextInt(4)+1;
            while(set.contains(index)){
                index=random.nextInt(4)+1;
            }
            set.add(index);
            indexs[i]=index;
        }
        question[indexs[0]]=questionList.get(questionIndex).getOption1();
        question[indexs[1]]=questionList.get(questionIndex).getOption2();
        question[indexs[2]]=questionList.get(questionIndex).getOption3();
        question[indexs[3]]=questionList.get(questionIndex).getOption4();

        return question;
    }
}

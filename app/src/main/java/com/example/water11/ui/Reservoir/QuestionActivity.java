package com.example.water11.ui.Reservoir;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.water11.R;
import com.example.water11.data.reservoir.Questions;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

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
                /*
                if(A.isChecked()){
                    Toast.makeText(getApplicationContext(),question[5],Toast.LENGTH_LONG).show();
                }else if(B.isChecked()){
                    Toast.makeText(getApplicationContext(),B.getText().toString(),Toast.LENGTH_LONG).show();
                }else if(C.isChecked()){
                    Toast.makeText(getApplicationContext(),C.getText().toString(),Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(),D.getText().toString(),Toast.LENGTH_LONG).show();
                }*/
                boolean isChoosen=false;
                for(RadioButton button:radioButtons){
                    if(button.isChecked()){
                        isChoosen=true;
                        if(button.getText().toString().equals(question[5])){
                            Toast.makeText(getApplicationContext(),"回答正确",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getApplicationContext(),"回答错误",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                if(isChoosen==false){
                    Toast.makeText(getApplicationContext(),"请选择答案。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。",Toast.LENGTH_SHORT).show();
                }
            }
        });

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }//去掉默认菜单栏
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

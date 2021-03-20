package com.example.water11.ui.home;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.water11.R;
import com.example.water11.data.reservoir.Questions;
import com.example.water11.ui.home.individual.IndividualFragment;

public class HomeFragment extends Fragment implements View.OnClickListener{

    private HomeViewModel homeViewModel;
    private Button btCurrent,btTask;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        replaceFragment(new IndividualFragment());
        btCurrent=root.findViewById(R.id.bt_current);
        btCurrent.setOnClickListener(this);
        btTask=root.findViewById(R.id.bt_task);
        btTask.setOnClickListener(this);

        btCurrent.setBackgroundColor(Color.WHITE);
        return root;
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.water_layout,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_current://个人当前用水按钮
                replaceFragment(new IndividualFragment());
                btCurrent.setBackgroundColor(Color.WHITE);
                btTask.setBackgroundColor(Color.rgb(50,131,160));
                break;
            case R.id.bt_task://我的任务按钮
                /*replaceFragment(new TaskFragment());
                btCurrent.setBackgroundColor(Color.rgb(50,131,160));
                btTask.setBackgroundColor(Color.WHITE);

                Questions questions1=new Questions();
                questions1.setTopic("我国将每年的（）定为中国水周。");
                questions1.setAnswer("3月22-28日");
                questions1.setOption1("3月22-28日");
                questions1.setOption2("4月22-28日");
                questions1.setOption3("5月22-28日");
                questions1.setOption4("7月22-28日");
                questions1.save();
                Questions questions2=new Questions();
                questions2.setTopic("人类可利用的淡水资源主要是指某地区逐年可恢复和（）的淡水资源。");
                questions2.setAnswer("更新");
                questions2.setOption1("更新");
                questions2.setOption2("开采");
                questions2.setOption3("储存");
                questions2.setOption4("消耗");
                questions2.save();*/
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
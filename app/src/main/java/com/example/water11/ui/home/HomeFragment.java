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
                btTask.setBackgroundColor(Color.WHITE);*/
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
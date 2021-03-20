package com.example.water11.ui.Reservoir;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.water11.tool.MySharedPreferences;
import com.example.water11.R;
import com.example.water11.data.reservoir.Game;
import com.example.water11.data.reservoir.Questions;
import com.example.water11.data.User;
import org.litepal.crud.DataSupport;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class ReservoirFragment extends Fragment {

    private View root;
    private TextView tvLevel;
    private User user;
    private int id;

    public static ReservoirFragment newInstance() {
        return new ReservoirFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.reservoir_fragment, container, false);

        id=(int) MySharedPreferences.getId(getActivity());
        user= DataSupport.find(User.class,id,true);
        Game game=user.getGame();
        int water=game.getWaterQuantity();

        tvLevel=root.findViewById(R.id.tv_level);
        tvLevel.setText(WaterNum.getLevel(water)+"");

        final Button btShop=root.findViewById(R.id.bt_shop);
        final Button btBag=root.findViewById(R.id.bt_bag);
        final Button btQuestion=root.findViewById(R.id.bt_question);
        btShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), ShopActivity.class);
                startActivity(intent);
        }
        });
        btBag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), BagActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });
        btQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), QuestionActivity.class);
                startActivity(intent);
            }
        });

        return root;
    }
}

class WaterNum{
    public static int getLevel(int waterQuantity){
        int level=0;
        if(waterQuantity<100){
            level=1;
        }else if(waterQuantity>=100&&waterQuantity<1000){
            level=2;
        }else if(waterQuantity>=1000&&waterQuantity<10000){
            level=3;
        }else if(waterQuantity>=10000&&waterQuantity<1e+5){
            level=4;
        }else if(waterQuantity>=1e+5&&waterQuantity<1e+6){
            level=5;
        }else{
            level=6;
        }
        return level;
    }
}
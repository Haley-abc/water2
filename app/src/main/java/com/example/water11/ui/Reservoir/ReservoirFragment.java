package com.example.water11.ui.Reservoir;

import androidx.lifecycle.ViewModelProviders;
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
import android.widget.Toast;
import com.example.water11.BagActivity;
import com.example.water11.MainActivity;
import com.example.water11.R;
import com.example.water11.ShopActivity;
import com.example.water11.data.Bag;
import com.example.water11.data.User;
import org.litepal.crud.DataSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReservoirFragment extends Fragment {

    private View root;
    private MainActivity activity;
    private int id;
    private  int poputionNumber;
    private int fishNumber;
    private int kitNumber;

    public static ReservoirFragment newInstance() {
        return new ReservoirFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.reservoir_fragment, container, false);
        activity=(MainActivity)getActivity();
        id=activity.getId();
        final User user= DataSupport.find(User.class,id);
        kitNumber=user.getKitNum();
        poputionNumber=user.getPolutionNum();
        fishNumber=user.getFishNum();

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String day=formatter.format(date);

        final Button btShop=root.findViewById(R.id.bt_shop);
        final Button btBag=root.findViewById(R.id.bt_bag);
        final Button btKit=root.findViewById(R.id.bt_kit);
        final Button btFish=root.findViewById(R.id.bt_fish);
        final Button btFish1=root.findViewById(R.id.bt_fish1);
        final Button btFish2=root.findViewById(R.id.bt_fish2);
        final Button btVirus1=root.findViewById(R.id.bt_virus1);
        final Button btVirus2=root.findViewById(R.id.bt_virus2);
        final Button btVirus3=root.findViewById(R.id.bt_virus3);
        final Button btVirus4=root.findViewById(R.id.bt_virus4);
        final Button btVirus5=root.findViewById(R.id.bt_virus5);
        final Button btVirus6=root.findViewById(R.id.bt_virus6);

        btKit.setVisibility(View.INVISIBLE);
        btFish.setVisibility(View.INVISIBLE);
        btFish1.setVisibility(View.INVISIBLE);
        btFish2.setVisibility(View.INVISIBLE);
        btVirus1.setVisibility(View.INVISIBLE);
        btVirus2.setVisibility(View.INVISIBLE);
        btVirus3.setVisibility(View.INVISIBLE);
        btVirus4.setVisibility(View.INVISIBLE);
        btVirus5.setVisibility(View.INVISIBLE);
        btVirus6.setVisibility(View.INVISIBLE);


        if(!user.getRefreshDate().equals(day)){
            int num=(int)(Math.random()*10+1);
            if(num==1){
                if(kitNumber==0){
                    kitNumber+=1;
                    user.setKitNum(kitNumber);
                    user.save();
                }
            }
            else if(num>4&&num<11){
                if(poputionNumber<10){
                    poputionNumber+=1;
                    user.setPolutionNum(poputionNumber);
                    user.save();
                }
            }
            else{
                if(fishNumber<3){
                    fishNumber+=1;
                    user.setFishNum(fishNumber);
                    user.save();
                }
            }
            user.setRefreshDate(day);
            user.save();
        }

        if(poputionNumber>0){
            btVirus1.setVisibility(View.VISIBLE);
        }
        if(poputionNumber>1){
            btVirus2.setVisibility(View.VISIBLE);
        }
        if(poputionNumber>2){
            btVirus3.setVisibility(View.VISIBLE);
        }
        if(poputionNumber>3){
            btVirus4.setVisibility(View.VISIBLE);
        }
        if(poputionNumber>4){
            btVirus5.setVisibility(View.VISIBLE);
        }
        if(poputionNumber>5){
            btVirus6.setVisibility(View.VISIBLE);
        }
        if(fishNumber>0){
            btFish.setVisibility(View.VISIBLE);
        }
        if(fishNumber>1){
            btFish1.setVisibility(View.VISIBLE);
        }
        if(fishNumber>2){
            btFish2.setVisibility(View.VISIBLE);
        }
        if (kitNumber==1){
            btKit.setVisibility(View.VISIBLE);
        }

        btKit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bag bag=new Bag();
                String name=partName();
                bag.setName(name);
                bag.setPicture(R.drawable.kit);
                bag.save();
                user.getBags().add(bag);
                user.save();
                if(user.save()){
                    Toast.makeText(getActivity(), "获得"+name+",放至背包", Toast.LENGTH_SHORT).show();
                    user.setKitNum(0);
                    user.save();
                }
                btKit.setVisibility(View.INVISIBLE);
            }
        });
        btVirus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "无机污染物—氰化钾", Toast.LENGTH_SHORT).show();
            }
        });
        btFish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "鱼", Toast.LENGTH_SHORT).show();
            }
        });
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


        /*
        经验增加规则
         */
        TextView coinNumber=(TextView)root.findViewById(R.id.tv_coin_number);
        String addNum="";
        if(!user.getReservoirDate().equals(day)){
            user.setReservoirDate(day);
            user.setReservoirDays(user.getReservoirDays()+1);
            if(user.getReservoirDays()==1){
                user.setCoin(user.getCoin()+6);
                addNum="6";
            }
            else if(user.getReservoirDays()>1&&user.getReservoirDays()<7){
                user.setCoin(user.getCoin()+8);
                addNum="8";
            }
            else if(user.getReservoirDays()>6&&user.getReservoirDays()<14){
                user.setCoin(user.getCoin()+10);
                addNum="18";
            }
            else{
                user.setCoin(user.getCoin()+15);
                addNum="23";
            }
            user.save();
            String a="经验+"+addNum;
            Toast.makeText(activity, a, Toast.LENGTH_SHORT).show();
        }


        return root;
    }

    /*
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ReservoirViewModel.class);
    }
     */

    public String partName(){
        int n=(int)(Math.random()*17+1);
        switch (n){
            case 1:
                return "隔离板-底板";
            case 2:
                return "隔离板-固定侧板";
            case 3:
                return "隔离板-活动侧板";
            case 4:
                return "沉浮舱本体-两根龙骨";
            case 5:
                return "沉浮舱本体-舱板";
            case 6:
                return "沉浮机构-充排水组件";
            case 7:
                return "沉浮机构-充排气组件";
            case 8:
                return "储物舱-底板";
            case 9:
                return "储物舱-固定侧板";
            case 10:
                return "储物舱-活动侧板";
            case 11:
                return "储物舱-两个沉浮舱";
            case 12:
                return "控制系统-系统供电的供电电源";
            case 13:
                return "控制系统-控制器和与控制器连接的水深检测模块";
            case 14:
                return "控制系统-充排气控制模块";
            case 15:
                return "控制系统-漂浮物深度检测模块";
            case 16:
                return "控制系统-水平测距模块";
            default:
                return "控制系统-驱动控制模块";
        }
    }
}

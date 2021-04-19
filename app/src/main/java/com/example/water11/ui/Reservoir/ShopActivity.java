package com.example.water11.ui.Reservoir;

import android.os.Bundle;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.water11.tool.MySharedPreferences;
import com.example.water11.R;
import com.example.water11.data.reservoir.Game;
import com.example.water11.data.User;
import com.example.water11.data.shop.Commodity;
import com.example.water11.data.shop.CommodityAdapter;
import com.example.water11.tool.BaseActivity;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class ShopActivity extends BaseActivity {
    private List<Commodity> commodityList=new ArrayList<Commodity>();
    private int id;
    private TextView tvCoinNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        //商品列表
        initCommodity();
        RecyclerView shopRecyclerView=(RecyclerView)findViewById(R.id.shop_list);
        LinearLayoutManager layoutManager=new LinearLayoutManager(ShopActivity.this);
        shopRecyclerView.setLayoutManager(layoutManager);
        CommodityAdapter adapter=new CommodityAdapter(commodityList);
        shopRecyclerView.setAdapter(adapter);

        id=(int) MySharedPreferences.getId(this);
        User user= DataSupport.find(User.class,id,true);
        Game game=user.getGame();
        int coinNum=game.getCoinNum();

        tvCoinNum=(TextView)findViewById(R.id.tv_coin_num);
        tvCoinNum.setText(Integer.toString(coinNum));//显示金币数

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }//去掉默认菜单栏
    }

    public void initCommodity(){
        Commodity commodity1=new Commodity("初级清洁工",40.0,R.drawable.primary_cleaner,"清理效果：伤害-40");
        commodityList.add(commodity1);
        Commodity commodity2=new Commodity("中级清洁工",70.0,R.drawable.intermediate_cleaner,"清理效果：伤害-70");
        commodityList.add(commodity2);
        Commodity commodity3=new Commodity("高级清洁工",100.0,R.drawable.senior_cleaner,"清理效果：伤害-100");
        commodityList.add(commodity3);
        Commodity commodity4=new Commodity("特级清洁工",200.0,R.drawable.super_cleaner,"清理效果：伤害-200");
        commodityList.add(commodity4);
        Commodity commodity5=new Commodity("鱼",2.0,R.drawable.fish,"");
        commodityList.add(commodity5);
        Commodity commodity6=new Commodity("睡莲",2.0,R.drawable.water_lilies,"");
        commodityList.add(commodity6);
        Commodity commodity7=new Commodity("水量",20.0,R.drawable.water_num,"100m³");
        commodityList.add(commodity7);
    }
}

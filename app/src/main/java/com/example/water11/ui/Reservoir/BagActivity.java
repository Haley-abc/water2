package com.example.water11.ui.Reservoir;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.water11.R;
import com.example.water11.data.User;
import com.example.water11.data.reservoir.Bag;
import com.example.water11.data.shop.Commodity;
import com.example.water11.data.shop.CommodityAdapter;
import com.example.water11.data.shop.Goods;
import com.example.water11.data.shop.GoodsAdapter;
import com.example.water11.tool.BaseActivity;
import com.example.water11.tool.MySharedPreferences;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class BagActivity extends BaseActivity {

    private List<Goods> goodsList=new ArrayList<Goods>();
    private int id;
    private User user;
    private Bag bag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bag);

        id=(int) MySharedPreferences.getId(this);
        user= DataSupport.find(User.class,id,true);

        bag=user.getBag();

        initGoods();
        RecyclerView bagRecyclerView=(RecyclerView)findViewById(R.id.bag_list);
        LinearLayoutManager layoutManager=new LinearLayoutManager(BagActivity.this);
        bagRecyclerView.setLayoutManager(layoutManager);
        GoodsAdapter adapter=new GoodsAdapter(goodsList);
        bagRecyclerView.setAdapter(adapter);

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }//去掉默认菜单栏
    }

    public void initGoods(){
        Goods goods1=new Goods("初级清洁工",R.drawable.head2,bag.getPrimaryCleaner());
        goodsList.add(goods1);
        Goods goods2=new Goods("中级清洁工",R.drawable.head2,bag.getIntermediateCleaner());
        goodsList.add(goods2);
        Goods goods3=new Goods("高级清洁工",R.drawable.head2,bag.getSeniorCleaner());
        goodsList.add(goods3);
        Goods goods4=new Goods("特级清洁工",R.drawable.head2,bag.getSuperCleaner());
        goodsList.add(goods4);
        Goods goods5=new Goods("鱼",R.drawable.head2,bag.getFish());
        goodsList.add(goods5);
        Goods goods6=new Goods("睡莲",R.drawable.head2,bag.getWaterLilies());
        goodsList.add(goods6);
        Goods goods7=new Goods("水量",R.drawable.head2,bag.getWaterNum());
        goodsList.add(goods7);
    }
}

package com.example.water11;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.water11.data.Game;
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
        for(int i=0;i<20;i++){
            Commodity commodity1=new Commodity("商品",20.0,R.drawable.head2);
            commodityList.add(commodity1);
            Commodity commodity2=new Commodity("商品",50.0,R.drawable.head2);
            commodityList.add(commodity2);
        }
    }

    public void insufficientGoldCoins(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("提示");
        builder.setMessage("金币不足！");
        builder.setPositiveButton("好的",
                new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        AlertDialog dialog=builder.create();
        dialog.show();
    }
}

package com.example.water11.data.shop;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.water11.data.reservoir.Bag;
import com.example.water11.tool.MySharedPreferences;
import com.example.water11.R;
import com.example.water11.data.reservoir.Game;
import com.example.water11.data.User;

import org.litepal.crud.DataSupport;

import java.util.List;

public class CommodityAdapter extends RecyclerView.Adapter<CommodityAdapter.ViewHolder>{
    private List<Commodity> mCommodityList;
    int id;
    private Game game;
    private int gameId;
    private Bag bag;
    private int bagId;

    public CommodityAdapter(List<Commodity> list){
        mCommodityList=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_shop,parent,false);

        id=(int) MySharedPreferences.getId(view.getContext());
        User user= DataSupport.find(User.class,id,true);
        game=user.getGame();
        gameId=game.getId();
        bag=user.getBag();
        bagId=bag.getId();
        final int coinNum=game.getCoinNum();

        final ViewHolder holder=new ViewHolder(view);
        holder.commodityView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Commodity commodity=mCommodityList.get(position);
                String commodityName=commodity.getName();
                if(coinNum<commodity.getPrice()){
                    insufficientGoldCoins(view);
                }else{
                    confirmPurchase(view,commodity.getPrice(),commodityName);
                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Commodity commodity=mCommodityList.get(position);
        holder.ivCommodityImage.setImageResource(commodity.getImageId());
        holder.tvCommodityList.setText(commodity.getName());
        holder.tvCommodityPrice.setText(commodity.getPrice()+"");
        holder.tvCommodityDes.setText(commodity.getDes());
    }

    @Override
    public int getItemCount() {
        return mCommodityList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View commodityView;
        ImageView ivCommodityImage;
        TextView tvCommodityList;
        TextView tvCommodityPrice;
        TextView tvCommodityDes;

        public ViewHolder(@NonNull View view) {
            super(view);
            commodityView=view;
            ivCommodityImage=(ImageView)view.findViewById(R.id.iv_commodity_image);
            tvCommodityList=(TextView)view.findViewById(R.id.tv_commodity_name);
            tvCommodityPrice=(TextView)view.findViewById(R.id.tv_commodity_price);
            tvCommodityDes=(TextView)view.findViewById(R.id.tv_commodity_des);
        }
    }

    public void insufficientGoldCoins(View v){
        AlertDialog.Builder builder=new AlertDialog.Builder(v.getContext());
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

    public void confirmPurchase(final View v, final double price, final String commodityName){
        final View view=v;
        AlertDialog.Builder builder=new AlertDialog.Builder(v.getContext());
        builder.setTitle("提示");
        builder.setMessage("确认购买？");
        builder.setPositiveButton("确定",
                new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        double coinNum=game.getCoinNum()-price;
                        ContentValues values=new ContentValues();
                        values.put("coinNum",coinNum);
                        DataSupport.update(Game.class,values,gameId);
                        addNum(commodityName);

                        Toast.makeText(view.getContext(), "购买成功", Toast.LENGTH_SHORT).show();
                    }
                });
        builder.setNegativeButton("取消",
                new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
        AlertDialog dialog=builder.create();
        dialog.show();
    }

    public void addNum(String type){
        ContentValues values=new ContentValues();
        int num;
        switch (type){
            case "鱼":
                num=bag.getFish()+1;
                values.put("fish",num);
                break;
            case "睡莲":
                num=bag.getWaterLilies()+1;
                values.put("waterLilies",num);
                break;
            case "水量":
                num=bag.getWaterNum()+1;
                values.put("waterNum",num);
                break;
            case "初级清洁工":
                num=bag.getPrimaryCleaner()+1;
                values.put("primaryCleaner",num);
                break;
            case "中级清洁工":
                num=bag.getIntermediateCleaner()+1;
                values.put("intermediateCleaner",num);
                break;
            case "高级清洁工":
                num=bag.getSeniorCleaner()+1;
                values.put("seniorCleaner",num);
                break;
            case "特级清洁工":
                num=bag.getSuperCleaner()+1;
                values.put("superCleaner",num);
                break;
            default:
                break;
        }
        DataSupport.update(Bag.class,values,bagId);
    }
}

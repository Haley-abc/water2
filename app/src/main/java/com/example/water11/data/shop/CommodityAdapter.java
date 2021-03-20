package com.example.water11.data.shop;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.water11.tool.MySharedPreferences;
import com.example.water11.R;
import com.example.water11.data.reservoir.Game;
import com.example.water11.data.User;

import org.litepal.crud.DataSupport;

import java.util.List;

public class CommodityAdapter extends RecyclerView.Adapter<CommodityAdapter.ViewHolder>{
    private List<Commodity> mCommodityList;
    int id;

    public CommodityAdapter(List<Commodity> list){
        mCommodityList=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_shop,parent,false);

        id=(int) MySharedPreferences.getId(view.getContext());
        User user= DataSupport.find(User.class,id,true);
        Game game=user.getGame();
        final int coinNum=game.getCoinNum();

        final ViewHolder holder=new ViewHolder(view);
        holder.commodityView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Commodity commodity=mCommodityList.get(position);
                if(coinNum<commodity.getPrice()){
                    insufficientGoldCoins(view);
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

        public ViewHolder(@NonNull View view) {
            super(view);
            commodityView=view;
            ivCommodityImage=(ImageView)view.findViewById(R.id.iv_commodity_image);
            tvCommodityList=(TextView)view.findViewById(R.id.tv_commodity_name);
            tvCommodityPrice=(TextView)view.findViewById(R.id.tv_commodity_price);
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
}

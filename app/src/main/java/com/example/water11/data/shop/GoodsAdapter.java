package com.example.water11.data.shop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.water11.R;

import java.util.List;

public class GoodsAdapter extends RecyclerView.Adapter<GoodsAdapter.ViewHolder>{
    private List<Goods> mGoodList;

    public GoodsAdapter(List<Goods> list){
        mGoodList=list;
    }

    @NonNull
    @Override
    public GoodsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_bag,parent,false);

        final GoodsAdapter.ViewHolder holder=new GoodsAdapter.ViewHolder(view);
        holder.goodsView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Goods good=mGoodList.get(position);
        holder.ivGoodsImage.setImageResource(good.getImageId());
        holder.tvGoodsName.setText(good.getName());
        holder.tvGoodsNum.setText(good.getNum()+"");
    }

    @Override
    public int getItemCount() {
        return mGoodList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View goodsView;
        ImageView ivGoodsImage;
        TextView tvGoodsName;
        TextView tvGoodsNum;

        public ViewHolder(@NonNull View view) {
            super(view);
            goodsView=view;
            ivGoodsImage=(ImageView)view.findViewById(R.id.iv_goods_image);
            tvGoodsName=(TextView)view.findViewById(R.id.tv_goods_name);
            tvGoodsNum=(TextView)view.findViewById(R.id.tv_goods_num);
        }
    }
}

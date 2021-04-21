package com.example.water11.data.service;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.water11.R;
import com.example.water11.ui.Service.activity.OnlineOptionActivity;
import com.example.water11.ui.WebActivity;

import java.util.List;

public class KnowledgeAdapter extends RecyclerView.Adapter<KnowledgeAdapter.ViewHolder>{

    private List<Knowledge> mKnowledgeeList;

    public KnowledgeAdapter(List<Knowledge> list){
        mKnowledgeeList=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_knowledge,parent,false);
        final KnowledgeAdapter.ViewHolder holder=new KnowledgeAdapter.ViewHolder(view);
        holder.knowledgeView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(view.getContext(), WebActivity.class);
                intent.putExtra("address",holder.address);
                v.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Knowledge knowledgeActivity=mKnowledgeeList.get(position);
        holder.ivKnowledgePicture.setImageResource(knowledgeActivity.getPicture());
        holder.tvKnowledgeTitle.setText(knowledgeActivity.getTitle());
        holder.tvKnowledgeContent.setText(knowledgeActivity.getContent());
        holder.tvKnowledgeTimes.setText("阅读次数："+knowledgeActivity.getTimes());
        holder.address=knowledgeActivity.getAddress();
    }

    @Override
    public int getItemCount() {
        return mKnowledgeeList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View knowledgeView;
        ImageView ivKnowledgePicture;
        TextView tvKnowledgeTitle;
        TextView tvKnowledgeContent;
        TextView tvKnowledgeTimes;
        String address;

        public ViewHolder(@NonNull View view) {
            super(view);
            knowledgeView=view;
            ivKnowledgePicture=(ImageView)view.findViewById(R.id.iv_knowledge_picture);
            tvKnowledgeTitle=(TextView)view.findViewById(R.id.tv_knowledge_title);
            tvKnowledgeContent=(TextView)view.findViewById(R.id.tv_knowledge_content);
            tvKnowledgeTimes=(TextView)view.findViewById(R.id.tv_knowledge_times);
        }
    }
}

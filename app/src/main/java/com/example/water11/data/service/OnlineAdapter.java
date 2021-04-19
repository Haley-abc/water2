package com.example.water11.data.service;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.water11.R;
import com.example.water11.ui.Service.activity.OnlineOptionActivity;

import java.util.List;

public class OnlineAdapter extends RecyclerView.Adapter<OnlineAdapter.ViewHolder>{
    private List<Online> mOnlineList;

    public OnlineAdapter(List<Online> list){
        mOnlineList=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_activity,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.onlineView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), OnlineOptionActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                v.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Online onlineActivity=mOnlineList.get(position);
        holder.tvOnlineTitle.setText(onlineActivity.getTille());
        holder.tvOnlineContent.setText(onlineActivity.getContent());
    }

    @Override
    public int getItemCount() {
        return mOnlineList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View onlineView;
        TextView tvOnlineTitle;
        TextView tvOnlineContent;

        public ViewHolder(@NonNull View view) {
            super(view);
            onlineView=view;
            tvOnlineTitle=(TextView)view.findViewById(R.id.tv_activity_title);
            tvOnlineContent=(TextView)view.findViewById(R.id.tv_activity_content);
        }
    }
}

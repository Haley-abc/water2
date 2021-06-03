package com.example.water11.ui.dashboard.advanced;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.water11.R;
import com.example.water11.data.User;
import com.example.water11.data.UserAdapter;

import java.util.List;

public class AdvancedAdapter extends RecyclerView.Adapter<AdvancedAdapter.ViewHolder>{

    private List<User> mUserList;

    public AdvancedAdapter(List<User> list){
        mUserList=list;
    }

    @NonNull
    @Override
    public AdvancedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        final AdvancedAdapter.ViewHolder holder=new AdvancedAdapter.ViewHolder(view);
        holder.userView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdvancedAdapter.ViewHolder holder, int position) {
        User userActivity=mUserList.get(position);
        holder.ivSortHead.setImageResource(R.drawable.head);
        holder.tvSortName.setText(userActivity.getNickName());
        holder.tvSortNum.setText(userActivity.getLevel()+"L");
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View userView;
        ImageView ivSortHead;
        TextView tvSortName;
        TextView tvSortNum;

        public ViewHolder(@NonNull View view) {
            super(view);
            userView=view;
            ivSortHead=(ImageView)view.findViewById(R.id.iv_sort_head);
            tvSortName=(TextView)view.findViewById(R.id.tv_sort_name);
            tvSortNum=(TextView)view.findViewById(R.id.tv_sort_num);
        }
    }
}

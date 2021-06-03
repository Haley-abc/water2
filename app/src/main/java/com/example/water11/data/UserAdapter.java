package com.example.water11.data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.water11.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{

    private List<User> mUserList;

    public UserAdapter(List<User> list){
        mUserList=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_friend,parent,false);
        final UserAdapter.ViewHolder holder=new UserAdapter.ViewHolder(view);
        holder.userView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User userActivity=mUserList.get(position);
        holder.ivFriendsHead.setImageResource(R.drawable.head);
        holder.tvFriendsName.setText(userActivity.getNickName());
        holder.tvFriendsNum.setText("节水量："+userActivity.getLevel()+"L");
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View userView;
        ImageView ivFriendsHead;
        TextView tvFriendsName;
        TextView tvFriendsNum;

        public ViewHolder(@NonNull View view) {
            super(view);
            userView=view;
            ivFriendsHead=(ImageView)view.findViewById(R.id.iv_friend_head);
            tvFriendsName=(TextView)view.findViewById(R.id.tv_friend_name);
            tvFriendsNum=(TextView)view.findViewById(R.id.tv_friends_num);
        }
    }
}

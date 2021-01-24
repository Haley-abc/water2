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

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    private List<Article> mArticleList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView userHead;
        TextView userName;
        TextView userContent;
        ImageView userPicture;

        public ViewHolder(@NonNull View view) {
            super(view);
            userHead=(ImageView)view.findViewById(R.id.user_head);
            userName=(TextView)view.findViewById(R.id.user_name);
            userContent=(TextView)view.findViewById(R.id.user_content);
            userPicture=(ImageView)view.findViewById(R.id.user_picture);
        }
    }

    public ArticleAdapter(List<Article> articleList){
        mArticleList=articleList;
    }

    @NonNull
    @Override
    public ArticleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_social,parent,false);
        ViewHolder hoder=new ViewHolder(view);
        return hoder;
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleAdapter.ViewHolder holder, int position) {
        Article article=mArticleList.get(position);
        holder.userHead.setImageResource(article.getUserHeadId());
        holder.userName.setText(article.getName());
        holder.userContent.setText(article.getContent());
        holder.userPicture.setImageResource(article.getUserPictureId());
    }

    @Override
    public int getItemCount() {
        return mArticleList.size();
    }
}

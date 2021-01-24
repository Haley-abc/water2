package com.example.water11.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.water11.IssueFragment;
import com.example.water11.MainActivity;
import com.example.water11.R;
import com.example.water11.data.Article;
import com.example.water11.data.ArticleAdapter;
import com.example.water11.data.SpaceSocialList;
import com.example.water11.data.User;
import com.example.water11.ui.home.task.TaskFragment;

import org.litepal.crud.DataSupport;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotificationsFragment extends Fragment implements View.OnClickListener{

    private View root;
    private MainActivity activity;
    private Button btSign,btIssue;
    private TextView tvDays;
    private int id,space=0;
    private User user;
    private String day;
    private List<Article> articleList=new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_notifications, container, false);

        initArticles();
        RecyclerView socialRecyclerView=(RecyclerView)root.findViewById(R.id.social_list);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this.getActivity());
        socialRecyclerView.setLayoutManager(layoutManager);
        ArticleAdapter adapter=new ArticleAdapter(articleList);
        socialRecyclerView.setAdapter(adapter);
        socialRecyclerView.addItemDecoration(new SpaceSocialList(space));

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        day=formatter.format(date);

        activity=(MainActivity)getActivity();
        id=activity.getId();
        user= DataSupport.find(User.class,id);//从MainActivity得到登陆者User信息

        btSign=root.findViewById(R.id.bt_sign);//签到按钮
        btSign.setOnClickListener(this);
        btIssue=root.findViewById(R.id.bt_issue);
        btIssue.setOnClickListener(this);

        tvDays=root.findViewById(R.id.tv_days);//签到天数TextView
        tvDays.setText(user.getDays()+"");

        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_sign:
                if(user.getDate().equals(day)){
                    Toast.makeText(activity,"今日已签到", Toast.LENGTH_SHORT).show();
                }
                else{
                    user.setDate(day);
                    user.setDays(user.getDays()+1);
                    user.save();
                    tvDays.setText(user.getDays()+"");
                    Toast.makeText(activity, "签到成功", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.bt_issue:
                replaceFragment(new IssueFragment());
                break;
            default:
                break;
        }
    }

    private void initArticles(){
        for(int i=0;i<5;i++){
            Article article1=new Article(R.drawable.head,"用户1","又是节约用水的一天！",R.drawable.kit);
            articleList.add(article1);
            Article article2=new Article(R.drawable.head,"用户1","又是节约用水的一天！",R.drawable.kit);
            articleList.add(article2);
        }
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.nav_host_fragment,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
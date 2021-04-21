package com.example.water11.ui.dashboard.progress;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.water11.R;
import com.example.water11.data.User;
import com.example.water11.ui.dashboard.advanced.AdvancedAdapter;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class ProgressFragment extends Fragment {

    private List<User> userList=new ArrayList<User>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.progress_fragment, container, false);

        initProgress();
        RecyclerView progressRecyclerView=(RecyclerView)root.findViewById(R.id.progress_list);
        LinearLayoutManager layoutManager=new LinearLayoutManager(root.getContext());
        progressRecyclerView.setLayoutManager(layoutManager);
        AdvancedAdapter adapter=new AdvancedAdapter(userList);
        progressRecyclerView.setAdapter(adapter);

        return root;
    }

    public void initProgress(){
        userList= DataSupport.select("nickName", "level","waterSaving").order("level desc").find(User.class);
    }
}

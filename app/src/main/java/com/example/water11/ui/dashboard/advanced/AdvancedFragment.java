package com.example.water11.ui.dashboard.advanced;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.water11.R;
import com.example.water11.data.User;
import com.example.water11.data.UserAdapter;
import com.example.water11.ui.notifications.FriendActivity;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class AdvancedFragment extends Fragment {

    private List<User> userList=new ArrayList<User>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.advanced_fragment, container, false);

        initAdvanced();
        RecyclerView advancedRecyclerView=(RecyclerView)root.findViewById(R.id.advanced_list);
        LinearLayoutManager layoutManager=new LinearLayoutManager(root.getContext());
        advancedRecyclerView.setLayoutManager(layoutManager);
        AdvancedAdapter adapter=new AdvancedAdapter(userList);
        advancedRecyclerView.setAdapter(adapter);

        return root;
    }

    public void initAdvanced(){
        userList= DataSupport.select("nickName", "level","waterSaving").order("level desc").find(User.class);
    }
}

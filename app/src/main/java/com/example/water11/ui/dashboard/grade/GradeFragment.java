package com.example.water11.ui.dashboard.grade;

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
import com.example.water11.ui.dashboard.advanced.AdvancedFragment;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class GradeFragment extends Fragment {

    private List<User> userList=new ArrayList<User>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.grade_fragment, container, false);

        initGrade();
        RecyclerView gradeRecyclerView=(RecyclerView)root.findViewById(R.id.grade_list);
        LinearLayoutManager layoutManager=new LinearLayoutManager(root.getContext());
        gradeRecyclerView.setLayoutManager(layoutManager);
        AdvancedAdapter adapter=new AdvancedAdapter(userList);
        gradeRecyclerView.setAdapter(adapter);

        return root;
    }

    public void initGrade(){
        userList= DataSupport.select("nickName", "level","waterSaving").order("level desc").find(User.class);
    }
}

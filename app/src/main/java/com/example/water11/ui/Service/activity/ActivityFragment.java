package com.example.water11.ui.Service.activity;

import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.water11.R;

public class ActivityFragment extends Fragment {

    private ActivityViewModel mViewModel;
    private View root;
    private Button btOnline;
    private Button btUnderline;

    public static ActivityFragment newInstance() {
        return new ActivityFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        root=inflater.inflate(R.layout.activity_fragment, container, false);

        btOnline=root.findViewById(R.id.bt_online);
        btUnderline=root.findViewById(R.id.bt_underline);

        btOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), OnlineActivity.class);
                startActivity(intent);
            }
        });

        btUnderline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), UnderlineActivity.class);
                startActivity(intent);
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ActivityViewModel.class);
        // TODO: Use the ViewModel
    }

}

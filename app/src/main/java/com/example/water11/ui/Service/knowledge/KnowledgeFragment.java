package com.example.water11.ui.Service.knowledge;

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
import com.example.water11.data.service.Knowledge;
import com.example.water11.data.service.KnowledgeAdapter;

import java.util.ArrayList;
import java.util.List;

public class KnowledgeFragment extends Fragment {

    private List<Knowledge> knowledgeList=new ArrayList<Knowledge>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.knowledge_fragment, container, false);

        initKnowledge();
        RecyclerView knowledgeRecyclerView=(RecyclerView)root.findViewById(R.id.knowledge_list);
        LinearLayoutManager layoutManager=new LinearLayoutManager(root.getContext());
        knowledgeRecyclerView.setLayoutManager(layoutManager);
        KnowledgeAdapter adapter=new KnowledgeAdapter(knowledgeList);
        knowledgeRecyclerView.setAdapter(adapter);

        return root;
    }

    public void initKnowledge(){
        Knowledge knowledge1=new Knowledge("2020年全国科普日来了！","   2020年全国科普日活动将于9月19日至25日在全国各地集中开展...","https://baijiahao.baidu.com/s?id=1678247188005126351&wfr=spider&for=pc",R.drawable.knowledge1,0);
        knowledgeList.add(knowledge1);
        Knowledge knowledge2=new Knowledge("3.22世界水日","   收藏学习！这些节水知识你都了解吗？...","https://baijiahao.baidu.com/s?id=1694897715885372627&wfr=spider&for=pc",R.drawable.knowledge2,0);
        knowledgeList.add(knowledge2);
    }
}

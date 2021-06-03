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
        Knowledge knowledge1=new Knowledge("2021年水利政策法规工作，17项要点值得关注","   2021年水利政策法规工作要坚持以习近平新时代中国特色社会主义思想为指导，深入贯彻落实党的十九届二中、三中、四中、五中全会精神…","https://www.thepaper.cn/newsDetail_forward_12175742",R.drawable.knowledge1,0);
        knowledgeList.add(knowledge1);
        Knowledge knowledge2=new Knowledge("3.22世界水日","   收藏学习！这些节水知识你都了解吗？...","https://baijiahao.baidu.com/s?id=1694897715885372627&wfr=spider&for=pc",R.drawable.knowledge2,0);
        knowledgeList.add(knowledge2);
        Knowledge knowledge3=new Knowledge("涨知识啦！！！","   细数历年“世界水日”主题和“中国水周”宣传主题","https://m.thepaper.cn/baijiahao_11822832",R.drawable.knowledge3,0);
        knowledgeList.add(knowledge3);
        Knowledge knowledge4=new Knowledge("新鲜出炉！2021年《世界水发展报告》","   与大多数其他珍贵的资源不同，水的真正“价值”很难被确定, 这一关键资源的总体重要性在世界许多地区的政治关注和财政投资中没有得到充分体现…","https://www.thepaper.cn/newsDetail_forward_11956746",R.drawable.knowledge4,0);
        knowledgeList.add(knowledge4);
    }
}

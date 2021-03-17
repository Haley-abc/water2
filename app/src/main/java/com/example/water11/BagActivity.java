package com.example.water11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.water11.data.Bag;
import com.example.water11.data.User;
import com.example.water11.tool.BaseActivity;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class BagActivity extends BaseActivity {
    private int id;
    private ListView mListView;
    private List<Bag> bags;
    private List<String> names=new ArrayList<String>();
    private List<Integer> pictures=new ArrayList<Integer>();
    private int[] icons={R.drawable.kit};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bag);

        Intent intent=getIntent();
        id=intent.getIntExtra("id",0);
        bags=DataSupport.select("name","picture").where("user_id=?",id+"").find(Bag.class);
        for(Bag ele:bags){
            names.add(ele.getName());
            pictures.add(ele.getPicture());
        }
        mListView=findViewById(R.id.bag_list);
        mListView.setAdapter(new BagActivity.MyBaseAdapter());
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }//去掉默认菜单栏
    }
    class MyBaseAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return names.size();
        }

        @Override
        public Object getItem(int position) {
            return names.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {//组装数据
            View view=View.inflate(BagActivity.this,R.layout.list_bag,null);//在list_item中有两个id,现在要把他们拿过来
            TextView mTextView=(TextView) view.findViewById(R.id.tv_list);
            ImageView imageView=(ImageView)view.findViewById(R.id.image);
            //组件一拿到，开始组装
            mTextView.setText(names.get(position));
            imageView.setBackgroundResource(icons[0]);
            //组装玩开始返回
            return view;
        }
    }
}

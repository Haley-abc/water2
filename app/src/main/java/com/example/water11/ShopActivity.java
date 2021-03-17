package com.example.water11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.water11.tool.BaseActivity;
import com.example.water11.ui.dashboard.advanced.AdvancedFragment;

public class ShopActivity extends BaseActivity {
    private ListView mListView;
    private  String[] names={"商品1","商品2","商品3","商品4","商品5","商品6","商品7","商品8","商品9","商品10","商品11","商品12","商品13","商品14"};
    private int[] icons={R.drawable.head2,R.drawable.head2,R.drawable.head2,R.drawable.head2,R.drawable.head2,R.drawable.head2,R.drawable.head2,R.drawable.head2,R.drawable.head2,R.drawable.head2,R.drawable.head2,R.drawable.head2,R.drawable.head2,R.drawable.head2};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        mListView=findViewById(R.id.shop_list);
        mListView.setAdapter(new ShopActivity.MyBaseAdapter());
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }//去掉默认菜单栏
    }
    class MyBaseAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int position) {
            return names [position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {//组装数据
            View view=View.inflate(ShopActivity.this,R.layout.list_shop,null);//在list_item中有两个id,现在要把他们拿过来
            TextView mTextView=(TextView) view.findViewById(R.id.tv_list);
            ImageView imageView=(ImageView)view.findViewById(R.id.image);
            //组件一拿到，开始组装
            mTextView.setText(names[position]);
            imageView.setBackgroundResource(icons[position]);
            //组装玩开始返回
            return view;
        }
    }
}

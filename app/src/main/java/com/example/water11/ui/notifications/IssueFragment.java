package com.example.water11.ui.notifications;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.water11.tool.MySharedPreferences;
import com.example.water11.R;
import com.example.water11.data.social.Article;
import com.example.water11.data.User;

import org.litepal.crud.DataSupport;

public class IssueFragment extends Fragment {

    private View root;
    private ImageView picture;
    private Button btTake,btIssue;
    private EditText etContent;
    int id;
    String content;//文章内容

    public static IssueFragment newInstance() {
        return new IssueFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        root=inflater.inflate(R.layout.fragment_issue, container, false);

        etContent=(EditText)root.findViewById(R.id.et_content);
        btIssue=(Button)root.findViewById(R.id.bt_issue);

        id=(int) MySharedPreferences.getId(root.getContext());
        final User user= DataSupport.find(User.class,id);

        btIssue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                content=etContent.getText().toString();
                if(content.length()==0){
                    Toast.makeText(root.getContext(), "内容不能为空", Toast.LENGTH_SHORT).show();
                }else {
                    String nickName=user.getNickName();
                    Article article = new Article();
                    article.setContent(content);
                    article.setName(nickName);
                    article.setUserHeadId(1);
                    article.setUserPictureId(1);
                    article.save();
                    if (article.save()) {
                        Toast.makeText(root.getContext(), "发表成功", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(root.getContext(), "发表失败", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        return root;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == 2) {
            // 从相册返回的数据
            if (data != null) {
                // 得到图片的全路径
                Uri uri = data.getData();
                picture.setImageURI(uri);
            }
        }
    }
}
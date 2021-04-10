package com.example.water11.ui.Service.activity;

import androidx.appcompat.app.AppCompatActivity;
import com.example.water11.R;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        WebView webView=(WebView)findViewById(R.id.wv_activity);
        webView.getSettings().setGeolocationEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://baijiahao.baidu.com/s?id=1696462447333890490&wfr=spider&for=pc");

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }//去掉默认菜单栏
    }
}

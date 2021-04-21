package com.example.water11.ui;

import androidx.appcompat.app.AppCompatActivity;
import com.example.water11.R;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent=getIntent();
        String address=intent.getStringExtra("address");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        WebView webView=(WebView)findViewById(R.id.wv_activity);
        webView.getSettings().setGeolocationEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(address);

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }//去掉默认菜单栏
    }
}

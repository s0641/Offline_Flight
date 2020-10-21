package com.app.gohigh;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Contact extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        WebView mywebview = (WebView) findViewById(R.id.webView);
        mywebview.loadUrl("https://www.pcloudy.com/");
    }
}
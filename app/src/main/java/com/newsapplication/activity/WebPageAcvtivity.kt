package com.newsapplication.activity

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.newsapplication.R

class WebPageAcvtivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_page_acvtivity)
        val webView=findViewById<WebView>(R.id.webView)
        webView.loadUrl(intent.getStringExtra("url")!!)

    }
}
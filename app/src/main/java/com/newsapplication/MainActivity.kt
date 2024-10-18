package com.newsapplication

import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import com.google.gson.internal.GsonBuildConfig
import com.newsapplication.ui.theme.NewsApplicationTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : ComponentActivity() {
    private val newsList = mutableListOf<News>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainactivity)

        lifecycleScope.launch {
            val progressBar=findViewById<ProgressBar>(R.id.progressBar)
            progressBar.isVisible=true
            val response = Retrofit.Builder().baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(
                    GsonConverterFactory.create()
                ).build().create(API::class.java)
                .getNews("techcrunch", "d5769bbf82b9478d8bd2b62f958ab688")
            if (response.isSuccessful && response.body() != null) {
                newsList.addAll(response.body()!!.articles)
                initialRecView()
                progressBar.isVisible=false
            }
            else
                Log.e("check res","nothing")
        }
    }

    private fun initialRecView() {
        val recView = findViewById<RecyclerView>(R.id.recView)
        val newsAdapter = NewsAdapter(newsList, this)
        recView.adapter = newsAdapter
        recView.layoutManager = LinearLayoutManager(this)
        val dividerItemDecoration=DividerItemDecoration(this,DividerItemDecoration.VERTICAL)
        recView.addItemDecoration(dividerItemDecoration)



    }


}


package com.newsapplication

import android.os.Bundle
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
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.newsapplication.ui.theme.NewsApplicationTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class MainActivity : ComponentActivity() {
   private val newsList=mutableListOf<News>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.mainactivity)
        initialRecView()
        lifecycleScope.launch {

        }
    }
    private fun initialRecView(){
        val recView=findViewById<RecyclerView>(R.id.recView)
        val newsAdapter=NewsAdapter(newsList,this)
        recView.adapter=newsAdapter
        recView.layoutManager= LinearLayoutManager(this)


    }
    private suspend fun networkCall(){
        delay(2000)
    }






}


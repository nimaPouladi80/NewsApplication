package com.newsapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class NewsAdapter(var newsList:MutableList<News>): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    class ViewHolder(view:View): RecyclerView.ViewHolder(view) {
        var title:TextView
        var dateAndWriter:TextView
        var description:TextView
        var imageView:TextView
        init {
            view.apply {
                title=findViewById(R.id.title)
                description=findViewById(R.id.description)
                dateAndWriter=findViewById(R.id.dateAndWriter)
                imageView=findViewById(R.id.imageView)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view= LayoutInflater.from(parent.context).inflate(R.layout.item_schematic,parent,false)
        return ViewHolder(view)


    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.apply {
        title.text=newsList[position].title
        description.text=newsList[position].description
        dateAndWriter.text=newsList[position].date+"\n"+newsList[position].writer
        //imageView.text=newsList[position].imageUri

    }
    }
}
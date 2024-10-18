package com.newsapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


@Suppress("DEPRECATION")
class NewsAdapter(var newsList:MutableList<News>, var contex:Context): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    @Suppress("DEPRECATION", "DEPRECATION")
    inner class ViewHolder(view:View): RecyclerView.ViewHolder(view) {
        var title:TextView
        var dateAndWriter:TextView
        var description:TextView
        var imageView:ImageView
        init {
            view.apply {
                title=findViewById(R.id.title)
                description=findViewById(R.id.description)
                dateAndWriter=findViewById(R.id.dateAndWriter)
                imageView=findViewById(R.id.imageView)
                title.setOnClickListener{
                    val intent=Intent(context,WebPageAcvtivity::class.java)
                    intent.putExtra("url",newsList[adapterPosition].url)
                    context.startActivity(intent)
                }
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
        dateAndWriter.text=newsList[position].publishedAt+"\n"+newsList[position].author
        Glide.with(contex).load(newsList[position].urlToImage).into(imageView)

    }
    }
}
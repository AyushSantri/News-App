package com.example.newsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter(private val items : ArrayList<String>,private val listener : NewsItemClicked): RecyclerView.Adapter<NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {

        //layoutInflater coverts xml into view which can be thus passed into view holder
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)

        val viewHolder = NewsViewHolder(view)
        view.setOnClickListener {
            listener.onItemClicked(items[viewHolder.adapterPosition])
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        //extracted the curr item from items array
        val currentItem = items[position]

        //then passes that item into viewHolder
        holder.titleView.text = currentItem
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val titleView : TextView = itemView.findViewById(R.id.title)
}

interface  NewsItemClicked {
    fun onItemClicked(item : String)
}
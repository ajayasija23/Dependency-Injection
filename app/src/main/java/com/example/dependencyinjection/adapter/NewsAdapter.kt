package com.example.dependencyinjection.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dependencyinjection.databinding.ItemNewsBinding
import com.example.dependencyinjection.model.Article
import com.example.dependencyinjection.utils.load

class NewsAdapter(val mContext: Context, val list:List<Article>):RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.MyViewHolder {
        return MyViewHolder(
            ItemNewsBinding.inflate(LayoutInflater.from(mContext),parent,false)
        )
    }

    override fun onBindViewHolder(holder: NewsAdapter.MyViewHolder, position: Int) {
        val item=list[position]
        holder.binding.tvTitle.text=item.title
        holder.binding.tvDesc.text=item.description
        if (item.urlToImage!=null){
            holder.binding.ivNews.load(item.urlToImage!!,mContext)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(val binding:ItemNewsBinding):RecyclerView.ViewHolder(binding.root)
}
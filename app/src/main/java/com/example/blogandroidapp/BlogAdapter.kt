package com.example.blogandroidapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class BlogAdapter(private val context: Context) : RecyclerView.Adapter<BlogAdapter.PostViewHolder>() {

    private var postList = mutableListOf<BlogPost>()

    fun setListData(data:MutableList<BlogPost>){
        postList = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.blog_item,
            parent, false)

        return PostViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val currentItem = postList[position]

        holder.titleTextView.text = currentItem.title
        Glide.with(context).load(currentItem.image).into(holder.imageView)
        holder.authorTextView.text = currentItem.userName
        holder.descTextView.text = currentItem.desc
        holder.dateTextView.text = currentItem.date
        holder.timeTextView.text = currentItem.time

    }

    override fun getItemCount(): Int {
        return if(postList.size > 0){
            postList.size
        } else {
            0
        }
    }

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.title_post)
        val imageView: ImageView = itemView.findViewById(R.id.image_view_post)
        val authorTextView: TextView = itemView.findViewById(R.id.author_post)
        val timeTextView: TextView = itemView.findViewById(R.id.time_post)
        val dateTextView: TextView = itemView.findViewById(R.id.date_post)
        val descTextView: TextView = itemView.findViewById(R.id.description_post)

    }
}
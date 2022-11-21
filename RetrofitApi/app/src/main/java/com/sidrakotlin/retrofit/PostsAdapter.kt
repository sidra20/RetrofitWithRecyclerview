package com.sidrakotlin.retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostsAdapter(private val context:Context, private val postsList:List<PostsItem>):RecyclerView.Adapter<PostsAdapter.MyViewHolder>()
{


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.posts_item,parent,false)
        val obj = MyViewHolder(view)
        return obj
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val posts = postsList[position]
        holder.id.text=posts.id.toString()
        holder.title.text=posts.title
    }

    override fun getItemCount(): Int {
        return postsList.size
    }

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        var id :TextView
        var title :TextView

        init {
            id = itemView.findViewById(R.id.postId)
            title=itemView.findViewById(R.id.title)
        }
    }
}
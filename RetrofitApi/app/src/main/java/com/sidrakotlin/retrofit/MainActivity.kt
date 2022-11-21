package com.sidrakotlin.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var adapter: PostsAdapter
    lateinit var recyclerView: RecyclerView
    lateinit var progress:ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progress=findViewById(R.id.progress)
        recyclerView = findViewById(R.id.recyclerPosts)
        recyclerView.layoutManager=LinearLayoutManager(this)

        val data = PostsApi.retrofitService.getPosts()

        data.enqueue(object : Callback<List<PostsItem>?> {
            override fun onResponse(
                call: Call<List<PostsItem>?>,
                response: Response<List<PostsItem>?>
            ) {
                progress.visibility=View.GONE
               val respBody = response.body()!!

                adapter=PostsAdapter(baseContext,respBody)
                adapter.notifyDataSetChanged()
                recyclerView.adapter=adapter
//                val respBody = response.body()!!
//                val strBuilder = StringBuilder()
//                for(posts in respBody){
//                    strBuilder.append(posts.id)
//                    strBuilder.append("\n")
//                }
//
//                text.text = strBuilder
            }

            override fun onFailure(call: Call<List<PostsItem>?>, t: Throwable) {
            Toast.makeText(applicationContext,""+t.message,Toast.LENGTH_SHORT).show()
            }
        })
    }
}
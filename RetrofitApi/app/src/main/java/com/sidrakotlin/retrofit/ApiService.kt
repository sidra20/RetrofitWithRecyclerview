package com.sidrakotlin.retrofit

import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
private const val BASE_URL ="https://jsonplaceholder.typicode.com/"



//private val retrofitBuilder = Retrofit.Builder()
//    .addConverterFactory(Sca.create())
//    .baseUrl(BASE_URL)
private val retrofitBuilder = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


interface ApiInterface{

    @GET("posts")
    fun getPosts(): Call<List<PostsItem>>
}

object PostsApi {
    val retrofitService:ApiInterface by lazy{

        retrofitBuilder.create(ApiInterface::class.java)
    }
}
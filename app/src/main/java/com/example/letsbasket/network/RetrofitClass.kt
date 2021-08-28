package com.example.letsbasket.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClass {
    //private val BASE_URL = "http://3.36.105.242"
    private val BASE_URL = "http://3.36.105.242:5000/"
    lateinit var apiPostDetail: ItempostInterface

    init{
        buildNetwork()
    }

    fun buildNetwork(){
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiPostDetail = retrofit.create(ItempostInterface::class.java)

    }
}
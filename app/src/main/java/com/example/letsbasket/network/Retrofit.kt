package com.example.letsbasket.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitBuilder {
    var api: ServiceApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://3.36.105.242:5000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(ServiceApi::class.java)
    }
}
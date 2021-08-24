package com.example.letsbasket.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitBuilder {
    var api: ServiceApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://3.36.105.242")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(ServiceApi::class.java)
    }
}
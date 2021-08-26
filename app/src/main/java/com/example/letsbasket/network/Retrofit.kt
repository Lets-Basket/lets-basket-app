package com.example.letsbasket.network

import com.example.letsbasket.manageToken.AuthInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitBuilder {
    var api: ServiceApi
    val okHttpClient = OkHttpClient.Builder().addInterceptor(AuthInterceptor()).build()

    init {
        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("http://3.36.105.242:5000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(ServiceApi::class.java)
    }
}
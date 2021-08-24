package com.example.letsbasket.network

import com.example.letsbasket.*
import com.example.letsbasket.login.LoginData
import com.example.letsbasket.login.LoginResponse
import retrofit2.Call
import retrofit2.http.*


interface ServiceApi {

    @POST("/api/posts")
    fun makePost(@Header("x-auth-token") xAuthToken: String, @Body data: UploadData): Call<UploadResponse>

    @POST("/api/auth")
    fun login(@Body data: LoginData): Call<LoginResponse>

}
//package com.example.letsbasket.network
//
//class Retrofit {
//    private val BASE_URL = "http://192.249.19.243:0480/"
//    private var retrofit: Retrofit? = null
//
//    fun getRetrofit(): Retrofit? {
//        if (retrofit == null) {
//            retrofit = Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//        }
//        return retrofit
//    }
//}
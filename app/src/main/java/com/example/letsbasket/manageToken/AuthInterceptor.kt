package com.example.letsbasket.manageToken

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    // Interceptor 를 상속받아 intercept method 구현
    override fun intercept(chain: Interceptor.Chain): Response {
        // chain에 Authorization 이라는 key와 prefs의 value를 가진 헤더를 붙인 뒤 return
        var req =
            chain.request().newBuilder().addHeader("Authorization", App.prefs.tokenVal ?: "").build()

        return chain.proceed(req)
    }
}
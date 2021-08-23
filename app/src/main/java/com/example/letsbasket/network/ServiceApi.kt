package com.example.letsbasket.network

import com.example.letsbasket.*
import retrofit2.Call
import retrofit2.http.*


interface ServiceApi {

    // x-www-urlencoded
//    @FormUrlEncoded // x-www-urlencoded로 보내겠다.
//    @POST("/rooms")
//    fun post(@FieldMap param: HashMap<String, String>): Call<RoomsData> // FieldMap을 사용해 여러개의 변수를 보내겠다 선언

    // Json
    @POST("/api/posts")
    fun makePost(@Header("x-auth-token") xAuthToken: String, @Body data: UploadData): Call<UploadResponse>

//
//    @POST("/user/login")
//    fun userLogin(@Body data: LoginData?): Call<LoginResponse?>?
//
//    @POST("/user/join")
//    fun userJoin(@Body data: JoinData?): Call<JoinResponse?>?
//
//    @POST("/question/upload")
//    fun makeQuestion(@Body data: MakeData?): Call<UploadResponse?>?
//
//    @POST("/question/get")
//    fun getQuestion(@Query("uid") uid: Int): Call<QuestionResponse?>?
//
//    @POST("/question/set")
//    fun setQuestion(@Body data: QuestionItem?): Call<SetResponse?>?
//
//    @POST("/answer/set")
//    fun setAnswer(@Body data: AnswerData?): Call<SetResponse?>?
//
//    @POST("/question/percent")
//    fun setPercent(@Query("qid") pid: Int): Call<PercentResponse?>?
}
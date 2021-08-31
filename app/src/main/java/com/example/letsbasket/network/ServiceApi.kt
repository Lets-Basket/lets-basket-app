package com.example.letsbasket.network

import com.example.letsbasket.*
import com.example.letsbasket.categoryTab.ItemsByCat
import com.example.letsbasket.itemDetail.IPostRequest
import com.example.letsbasket.itemDetail.LikeResponse
import com.example.letsbasket.itemDetail.SingleItem
import com.example.letsbasket.login.LoginData
import com.example.letsbasket.login.LoginResponse
import retrofit2.Call
import retrofit2.http.*


interface ServiceApi {

    // 글쓰기
    @POST("/api/posts")
    fun makePost(@Header("x-auth-token") xAuthToken: String, @Body data: UploadData): Call<UploadResponse>

    // 로그인
    @POST("/api/auth")
    fun login(@Body data: LoginData): Call<LoginResponse>

    // 게시물 상세 조회
    @GET("/api/posts/detail/{post_id}")
    fun getItem(
        @Header("x-auth-token") auth: String,
        @Path("post_id") postID: String): Call<SingleItem>

    // 좋아요 추가
    @POST("/api/posts/like")
    fun addLike(
        @Header("x-auth-token") auth: String,
        @Body postID: IPostRequest
    ): Call<LikeResponse>

    // 좋아요 삭제
    @DELETE("/api/posts/like/{post_id}")
    fun deleteLike(
        @Header("x-auth-token") auth: String,
        @Path("post_id") postID: String): Call<LikeResponse>

    // 딜 참여
    @POST("/api/posts/deal")
    fun addRoom(
        @Header("x-auth-token") auth: String,
        @Body postID: IPostRequest
    ): Call<ParticipateDealResponse>

    // 카테고리별 게시글 조회
    @GET("/api/posts/{category}")
    fun getItemByCat(
        @Header("x-auth-token") auth: String,
        @Path("category") categoryID: Int
        //): Call<GetItemsbyCatResponse>
    ): Call<List<ItemsByCat>>

}
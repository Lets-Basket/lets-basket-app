package com.example.letsbasket.mypageTab

import com.google.gson.annotations.SerializedName

data class MypageData(
    var favoritecategory: Array<Int>,
    var recommend: Array<String>,
    var clicks: Array<String>,
    var deals: Array<String>,
    var rooms: Array<String>,
    @SerializedName("_id") var userId: String,
    var studentcard: String,
    var name: String,
    var studentnum: Int,
    var major: String,
    var dong: String,
    var latitude: Float,
    var longtitude: Float,
    @SerializedName("id") var nickname: String,
    var pw: String,
    var phonenum: String,
    var date: String,
    @SerializedName("_v") var v: Int
)

package com.example.letsbasket.network

import com.google.gson.annotations.SerializedName
import retrofit2.Call

data class ParticipateDealResponse(
    var users: Array<String>,
    @SerializedName("_id") var dealID: String,
    var room_id: String,
    var user_number: Int,
    var post_id: String,
    @SerializedName("__v") var v: Int
)

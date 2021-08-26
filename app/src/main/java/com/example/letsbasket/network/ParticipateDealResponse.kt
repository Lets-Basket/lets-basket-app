package com.example.letsbasket.network

import com.google.gson.annotations.SerializedName

data class ParticipateDealResponse(
    var users: Array<String>,
    @SerializedName("_id") var postID: String,
    var room_id: String,
    var user_number: Int

)

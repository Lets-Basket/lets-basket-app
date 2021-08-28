package com.example.letsbasket.network

import com.google.gson.annotations.SerializedName

data class GetPostsResponse(
    var item: List<Items>
    )

data class Items(
    var participantsId: Array<String>,
    @SerializedName("_id") var post_id: String,
    var title: String,
    var dong: String,
    var price: Int,
    var peopleNum: Int,
    var deadline: String,
    var opener: String,
    var date: String
)
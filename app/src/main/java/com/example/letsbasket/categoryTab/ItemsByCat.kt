package com.example.letsbasket.categoryTab

import com.example.letsbasket.network.Items
import com.google.gson.annotations.SerializedName
import org.json.JSONArray

// 특정 카테고리 해당 상품 정보
// 이걸 리스트로 GET
data class ItemsByCat(
    var likes: Int,
    var clicks: Int,
    var available: Boolean,
    var participantsId: Array<String>,
    @SerializedName("_id") var postID: String,
    var title: String,
    var dong: String,
    var price: Int,
    var peopleNum: Int,
    var deadline: String,
    var category: Int,
    var img: String,
    var url: String,
    var desc: String,
    var opener: String,
    var openerName: String,
    var date: String,
    @SerializedName("__v") var v: Int
)

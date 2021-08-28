package com.example.letsbasket.itemDetail

import com.google.gson.annotations.SerializedName

data class SingleItem(
    var data: ItemData,
    var like: Boolean
)

data class ItemData(
    var likes: Int,
    var clicks: Int,
    var available: Boolean,
    @SerializedName("participantsIds")var participantsID: Array<String>,
    @SerializedName("_id") var id: String,
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

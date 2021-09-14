package com.example.letsbasket.mypageTab

data class MypageResponse(
    val __v: Int,
    val _id: String,
    val clicks: List<String>,
    val date: String,
    val deals: List<String>,
    val dong: String,
    val favoritecategory: List<Int>,
    val id: String,
    val latitude: Double,
    val likes: List<String>,
    val longtitude: Double,
    val major: String,
    val name: String,
    val phonenum: String,
    val pw: String,
    val recommend: List<Any>,
    val rooms: List<String>,
    val studentcard: String,
    val studentnum: Int
)
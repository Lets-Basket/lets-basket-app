package com.example.letsbasket.network

data class PostResponse (
    var likes: Int,
    var clicks: Int,
    var available: Boolean,
    var img: String,
    var url: String,
    var category: Int,
    var desc: String,
    var _id: String,
    var date: String,
    var deadline: String,
    var dong: String,
    var opener: String,
    var openerName: String,
    var participantsId: List<String>,
    var peopleNum: Int,
    var price: Int,
    var title: String,
    var __v: Int
)

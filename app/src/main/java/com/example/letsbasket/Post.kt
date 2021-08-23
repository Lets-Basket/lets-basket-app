package com.example.letsbasket

data class Post(
    val __v: Int,
    val _id: String,
    val available: Boolean,
    val category: Int,
    val clicks: Int,
    val date: String,
    val deadline: String,
    val desc: String,
    val dong: String,
    val img: String,
    val likes: Int,
    val opener: String,
    val openerName: String,
    val participantsId: List<String>,
    val peopleNum: Int,
    val price: Int,
    val title: String,
    val url: String
)
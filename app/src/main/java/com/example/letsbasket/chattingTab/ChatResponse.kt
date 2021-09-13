package com.example.letsbasket.chattingTab

data class ChatResponse(
    val __v: Int,
    val _id: String,
    val post_id: PostId,
    val room_id: String,
    val user_number: Int,
    val users: List<String>
)
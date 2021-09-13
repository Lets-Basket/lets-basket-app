package com.example.letsbasket.chattingTab

data class ChatResponse(
    var __v: Int,
    var _id: String,
    var post_id: PostId,
    var room_id: String,
    var user_number: Int,
    var users: List<String>
)
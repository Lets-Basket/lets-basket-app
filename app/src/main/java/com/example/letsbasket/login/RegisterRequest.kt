package com.example.letsbasket.login


data class RegisterRequest(
    var favoritecategory: Array<Int>? = null,
    var studentcard: String? = null,
    var name: String? = null,
    var studentnum: Int? = null,
    var major: String? = null,
    var dong: String? = null,
    var latitude: Double? = null,
    var longtitude: Double? = null,
    var id: String? = null,
    var pw: String? = null,
    var phonenum: String? = null
)

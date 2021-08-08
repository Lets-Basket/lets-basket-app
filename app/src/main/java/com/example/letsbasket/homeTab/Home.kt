package com.example.letsbasket.homeTab

data class Home(var id: Int, var name: String, var phoneNumber: String)

class HomePriority{
    companion object{
        const val LOW_PRIORITY = 100
        const val HIGH_PRIORITY = 0
    }
}
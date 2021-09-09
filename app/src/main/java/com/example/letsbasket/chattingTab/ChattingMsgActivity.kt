package com.example.letsbasket.chattingTab

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.letsbasket.FragmentTab
import com.example.letsbasket.MapActivity
import com.example.letsbasket.R

class ChattingMsgActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_chat_msg)

        val recPlaceBtn = findViewById<Button>(R.id.recPlace)

        recPlaceBtn.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }
    }
}
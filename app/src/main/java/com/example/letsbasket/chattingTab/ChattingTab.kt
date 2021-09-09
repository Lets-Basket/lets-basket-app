package com.example.letsbasket.chattingTab

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.example.letsbasket.FragmentTab
import com.example.letsbasket.MapActivity
import com.example.letsbasket.R
import com.example.letsbasket.WritingActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_chatting_tab.*

class ChattingTab : FragmentTab() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.activity_chatting_tab, container, false)

//        val enterBtn = view.findViewById<EditText>(R.id.enter_btn)

//        val floatingButton = view.findViewById<FloatingActionButton>(R.id.dealOpen)
//        floatingButton.setOnClickListener {
//            val intent = Intent(this.activity, WritingActivity::class.java)
//            startActivity(intent)
//        }
//        enterBtn.setOnClickListener {
            val intent = Intent(this.activity, ChattingMsgActivity::class.java)
            startActivity(intent)
//        }




        return view
    }
}
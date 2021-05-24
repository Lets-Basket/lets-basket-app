package com.example.letsbasket.homeTab

import android.content.Intent
import com.example.letsbasket.FragmentTab
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.example.letsbasket.R
import com.example.letsbasket.WritingActivity

class HomeTab : FragmentTab() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.activity_home_tab, container, false)

        val floatingButton = view.findViewById<FloatingActionButton>(R.id.dealOpen)
        floatingButton.setOnClickListener {
            val intent = Intent(this.activity, WritingActivity::class.java)
            startActivity(intent)
        }



        return view
    }
}
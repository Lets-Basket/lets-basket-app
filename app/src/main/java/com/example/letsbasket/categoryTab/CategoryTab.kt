package com.example.letsbasket.categoryTab

import android.app.Activity
import android.content.Intent
import com.example.letsbasket.FragmentTab
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.letsbasket.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_category_tab.*

class CategoryTab : FragmentTab() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.activity_category_tab, container, false)

        val btn1 = view.findViewById<Button>(R.id.btnCat1)

        btn1.setOnClickListener {
            val intent = Intent(getActivity(), CategoryActivity::class.java)
            startActivity(intent)
        }

        return view
    }
}
package com.example.letsbasket.categoryTab

import android.content.Intent
import com.example.letsbasket.FragmentTab
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.letsbasket.R

class CategoryTab : FragmentTab() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.activity_category_tab, container, false)

        val btn1 = view.findViewById<Button>(R.id.btnCat1)
        val btn2 = view.findViewById<Button>(R.id.btnCat2)
        val btn3 = view.findViewById<Button>(R.id.btnCat3)

        btn1.setOnClickListener {
            val intent = Intent(getActivity(), CategoryActivity::class.java)
            intent.putExtra("catNum", 1)
            startActivity(intent)
        }

        btn2.setOnClickListener {
            val intent = Intent(getActivity(), CategoryActivity::class.java)
            intent.putExtra("catNum", 2)
            startActivity(intent)
        }

        btn3.setOnClickListener {
            val intent = Intent(getActivity(), CategoryActivity::class.java)
            intent.putExtra("catNum", 3)
            startActivity(intent)
        }

        return view
    }
}
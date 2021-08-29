package com.example.letsbasket.categoryTab

import android.content.Intent
import com.example.letsbasket.FragmentTab
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.letsbasket.R
import kotlinx.android.synthetic.main.activity_category_tab.*

class CategoryTab : FragmentTab() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.activity_category_tab, container, false)

//        val intent = Intent(getActivity(), ItemActivity::class.java)
//        startActivity(intent)

        return view
    }
}
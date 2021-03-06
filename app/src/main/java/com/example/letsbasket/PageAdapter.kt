package com.example.letsbasket

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class PageAdapter(fm : FragmentManager) : FragmentStatePagerAdapter(fm){
    private var fragments : ArrayList<FragmentTab> = ArrayList()

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int = fragments.size

    fun addItems(fragment : FragmentTab){
        fragments.add(fragment)
    }
}
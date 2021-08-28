package com.example.letsbasket.homeTab

import android.content.Context
import android.content.Intent
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import com.example.letsbasket.FragmentTab
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.example.letsbasket.R
import com.example.letsbasket.WritingActivity
import java.io.IOException
import java.util.*

class HomeTab : FragmentTab() {

    var phoneAdapter: HomeRecycleAdapter =
        HomeRecycleAdapter()
    var recycleview: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.activity_home_tab, container, false)
//
//        recycleview  = view.findViewById<RecyclerView>(R.id.HomeRecycleView)
//        val data:MutableList<Home> = loadDataWithPermissionCheck()
//
//        phoneAdapter.setList(data)
//        recycleview?.adapter = phoneAdapter
//        recycleview?.layoutManager = LinearLayoutManager(activity)

        val floatingButton = view.findViewById<FloatingActionButton>(R.id.dealOpen)
        floatingButton.setOnClickListener {
            val intent = Intent(this.activity, WritingActivity::class.java)
            startActivity(intent)
        }



        return view
    }

    override fun onResume() {
        super.onResume()

//        val data:MutableList<Home> = loadDataWithPermissionCheck()
//
//        Log.d("myPhone", "size: ${data.size}")
//
//        phoneAdapter.setList(data)
//
//        Log.d("myPhone", "size after: ${phoneAdapter.listData.size}")
//        recycleview?.adapter = phoneAdapter
//        recycleview?.layoutManager = LinearLayoutManager(activity)

    }


//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val view =inflater.inflate(R.layout.activity_home_tab, container, false)
//
//        val floatingButton = view.findViewById<FloatingActionButton>(R.id.dealOpen)
//        floatingButton.setOnClickListener {
//            val intent = Intent(this.activity, WritingActivity::class.java)
//            startActivity(intent)
//        }
//
//        return view
//    }
}
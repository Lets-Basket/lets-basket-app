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
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.example.letsbasket.R
import com.example.letsbasket.UploadResponse
import com.example.letsbasket.WritingActivity
import com.example.letsbasket.categoryTab.CategoryAdapter
import com.example.letsbasket.categoryTab.ItemsByCat
import com.example.letsbasket.network.RetrofitBuilder
import kotlinx.android.synthetic.main.activity_item_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.util.*

class HomeTab : FragmentTab() {

    lateinit var categoryAdapter: CategoryAdapter
    val datas = mutableListOf<ItemsByCat>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_home_tab, container, false)
        val allBtn = view.findViewById<Button>(R.id.allBtn)
        val recBtn = view.findViewById<Button>(R.id.recBtn)
        val latestBtn = view.findViewById<Button>(R.id.latestBtn)
        val deadlineBtn = view.findViewById<Button>(R.id.deadlineBtn)


        allBtn.setOnClickListener {
            RetrofitBuilder.api.getAllItem().enqueue(object : Callback<List<ItemsByCat>> {
                override fun onResponse(call: Call<List<ItemsByCat>>, response: Response<List<ItemsByCat>>) {
                    if(response.isSuccessful()) { // <--> response.code == 200
                        Log.d("결과", "성공 : ${response.body()}")

                        val jsonString = response.body()!!
                        val categoryAdapter = CategoryAdapter(requireActivity())

                        itemList.adapter = categoryAdapter
                        datas.apply{
                            datas.clear();
                            addAll(jsonString)
                            categoryAdapter.datas = datas
                            categoryAdapter.notifyDataSetChanged()
                        }


                    } else { // code == 400
                        Log.d("결과", "뭔가 잘못됐어 : ${response.raw()}")
                    }
                }

                override fun onFailure(call: Call<List<ItemsByCat>>, t: Throwable) { // code == 500
                    // 실패 처리
                    Log.d("결과:", "실패 : $t")
                }
            })
        }

        recBtn.setOnClickListener {
            RetrofitBuilder.api.getRecItem().enqueue(object : Callback<List<ItemsByCat>> {
                override fun onResponse(call: Call<List<ItemsByCat>>, response: Response<List<ItemsByCat>>) {
                    if(response.isSuccessful()) { // <--> response.code == 200
                        Log.d("결과", "성공 : ${response.body()}")

                        val jsonString = response.body()!!
                        val categoryAdapter = CategoryAdapter(requireActivity())

                        itemList.adapter = categoryAdapter
                        datas.apply{
                            datas.clear();
                            addAll(jsonString)
                            categoryAdapter.datas = datas
                            categoryAdapter.notifyDataSetChanged()
                        }


                    } else { // code == 400
                        Log.d("결과", "뭔가 잘못됐어 : ${response.raw()}")
                    }
                }

                override fun onFailure(call: Call<List<ItemsByCat>>, t: Throwable) { // code == 500
                    // 실패 처리
                    Log.d("결과:", "실패 : $t")
                }
            })
        }

        latestBtn.setOnClickListener {
            RetrofitBuilder.api.getLatestItem("청파동").enqueue(object : Callback<List<ItemsByCat>> {
                override fun onResponse(call: Call<List<ItemsByCat>>, response: Response<List<ItemsByCat>>) {
                    if(response.isSuccessful()) { // <--> response.code == 200
                        Log.d("결과", "성공 : ${response.body()}")

                        val jsonString = response.body()!!
                        val categoryAdapter = CategoryAdapter(requireActivity())

                        itemList.adapter = categoryAdapter
                        datas.apply{
                            datas.clear();
                            addAll(jsonString)
                            categoryAdapter.datas = datas
                            categoryAdapter.notifyDataSetChanged()
                        }


                    } else { // code == 400
                        Log.d("결과", "뭔가 잘못됐어 : ${response.raw()}")
                    }
                }

                override fun onFailure(call: Call<List<ItemsByCat>>, t: Throwable) { // code == 500
                    // 실패 처리
                    Log.d("결과:", "실패 : $t")
                }
            })
        }

        deadlineBtn.setOnClickListener {
            RetrofitBuilder.api.getDeadlineItem("청파동").enqueue(object : Callback<List<ItemsByCat>> {
                override fun onResponse(call: Call<List<ItemsByCat>>, response: Response<List<ItemsByCat>>) {
                    if(response.isSuccessful()) { // <--> response.code == 200
                        Log.d("결과", "성공 : ${response.body()}")

                        val jsonString = response.body()!!
                        val categoryAdapter = CategoryAdapter(requireActivity())

                        itemList.adapter = categoryAdapter
                        datas.apply{
                            datas.clear();
                            addAll(jsonString)
                            categoryAdapter.datas = datas
                            categoryAdapter.notifyDataSetChanged()
                        }


                    } else { // code == 400
                        Log.d("결과", "뭔가 잘못됐어 : ${response.raw()}")
                    }
                }

                override fun onFailure(call: Call<List<ItemsByCat>>, t: Throwable) { // code == 500
                    // 실패 처리
                    Log.d("결과:", "실패 : $t")
                }
            })
        }



        val floatingButton = view.findViewById<FloatingActionButton>(R.id.dealOpen)
        floatingButton.setOnClickListener {
            val intent = Intent(this.activity, WritingActivity::class.java)
            startActivity(intent)
        }

        return view
    }

//    override fun onResume() {
//        super.onResume()
//    }

}
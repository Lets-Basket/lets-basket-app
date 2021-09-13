package com.example.letsbasket.chattingTab

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.example.letsbasket.FragmentTab
import com.example.letsbasket.MapActivity
import com.example.letsbasket.R
import com.example.letsbasket.categoryTab.ChattingAdapter
import com.example.letsbasket.categoryTab.ItemsByCat
import com.example.letsbasket.network.RetrofitBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_chatting_tab.*
import kotlinx.android.synthetic.main.activity_item_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChattingTab : FragmentTab() {
    lateinit var chattingAdapter: ChattingAdapter
    val datas = mutableListOf<ChatResponse>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.activity_chatting_tab, container, false)

        RetrofitBuilder.api.getChatList().enqueue(object : Callback<List<ChatResponse>> {
            override fun onResponse(call: Call<List<ChatResponse>>, response: Response<List<ChatResponse>>) {
                if(response.isSuccessful()) { // <--> response.code == 200
                    Log.d("결과", "성공 : ${response.body()}")

                    val jsonString = response.body()!!
                    val chattingAdapter = ChattingAdapter(requireActivity())

                    chatItemList.adapter = chattingAdapter
                    datas.apply{
                        datas.clear();
                        addAll(jsonString)
                        chattingAdapter.datas = datas
                        chattingAdapter.notifyDataSetChanged()
                    }


                } else { // code == 400
                    Log.d("결과", "뭔가 잘못됐어 : ${response.raw()}")
                }
            }

            override fun onFailure(call: Call<List<ChatResponse>>, t: Throwable) { // code == 500
                // 실패 처리
                Log.d("결과:", "실패 : $t")
            }
        })

//        val enterBtn = view.findViewById<EditText>(R.id.enter_btn)

//        val floatingButton = view.findViewById<FloatingActionButton>(R.id.dealOpen)
//        floatingButton.setOnClickListener {
//            val intent = Intent(this.activity, WritingActivity::class.java)
//            startActivity(intent)
//        }
//        enterBtn.setOnClickListener {
//            val intent = Intent(this.activity, ChattingMsgActivity::class.java)
//            startActivity(intent)
//        }




        return view
    }
}
package com.example.letsbasket.chattingTab

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.letsbasket.FragmentTab
import com.example.letsbasket.MapActivity
import com.example.letsbasket.R
import com.example.letsbasket.R.id.send_iv
import com.example.letsbasket.categoryTab.ChatMsgAdapter
import com.example.letsbasket.categoryTab.ChatMsgAdapter2
import com.example.letsbasket.categoryTab.ChattingAdapter
import com.example.letsbasket.login.RegisterRequest
import com.example.letsbasket.manageToken.App
import com.example.letsbasket.mypageTab.MypageResponse
import com.example.letsbasket.network.RetrofitBuilder
import kotlinx.android.synthetic.main.activity_chatting_tab.*
import kotlinx.android.synthetic.main.activity_item_post.*
import kotlinx.android.synthetic.main.activity_item_post.postTitle
import kotlinx.android.synthetic.main.fragment_chat_msg.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChattingMsgActivity : Activity() {

    lateinit var chatMshAdapter: ChatMsgAdapter
    val datas = mutableListOf<ChatMsgItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_chat_msg)

        var chatData = ChatMsgItem()

        val roomId = intent.getStringExtra("roomId").toString()
        Log.d("결과", roomId)

        val recPlaceBtn = findViewById<ImageButton>(R.id.recPlace)
        val content = findViewById<EditText>(R.id.content_et)
        val send = findViewById<ImageView>(R.id.send_iv)


        RetrofitBuilder.api.getChatContent(roomId).enqueue(object : Callback<ChatResponse> {
            override fun onResponse(call: Call<ChatResponse>, response: Response<ChatResponse>) {
                if(response.isSuccessful()) { // <--> response.code == 200
                    Log.d("결과", "성공 : ${response.body()}")

                    val data = response.body()!!

                    Log.d("결과", "${data.users[0]}, ${data.post_id.title}, ${data.post_id.price.toString()}")
                    participant.text = data?.users[0]
                    postTitle.text = data.post_id.title
                    postPrice.text = data.post_id.price.toString() + "원"
                    Glide.with(this@ChattingMsgActivity).load(data.post_id.img).error(R.drawable.default_img).into(postImage)


                } else { // code == 400
                    Log.d("결과", "뭔가 잘못됐어 : ${response.raw()}")
                }
            }

            override fun onFailure(call: Call<ChatResponse>, t: Throwable) { // code == 500
                // 실패 처리
                Log.d("결과:", "실패 : $t")
            }
        })

        RetrofitBuilder.api.getMypage().enqueue(object : Callback<List<MypageResponse>> {
            override fun onResponse(call: Call<List<MypageResponse>>, response: Response<List<MypageResponse>>) {
                if(response.isSuccessful()) { // <--> response.code == 200
                    Log.d("결과", "성공 : ${response.body()}")

                    val data = response.body()!!



                    if (data[0].name == "성청하") {

                        chatData.date_tv2 = "2021-09-14"
                        chatData.content_tv2 = "베이글 팩토리에서 만나요"

                        val chatMshAdapter = ChatMsgAdapter2(this@ChattingMsgActivity)

                        chat_msg_rv.adapter = chatMshAdapter
                        datas.apply{
                            addAll(listOf(chatData))
                            chatMshAdapter.datas = datas
                            chatMshAdapter.notifyDataSetChanged()
                        }
                    }


                } else { // code == 400
                    Log.d("결과!!!", "뭔가 잘못됐어 : ${response.raw()}")
                }
            }

            override fun onFailure(call: Call<List<MypageResponse>>, t: Throwable) { // code == 500
                // 실패 처리
                Log.d("결과:", "실패 : $t")
            }
        })

        recPlaceBtn.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }

        send.setOnClickListener{

            chatData.date_tv2 = "2021-09-14"
            chatData.content_tv2 = content?.text.toString()

            val chatMshAdapter = ChatMsgAdapter(this)

            chat_msg_rv.adapter = chatMshAdapter
            datas.apply{
                addAll(listOf(chatData))
                chatMshAdapter.datas = datas
                chatMshAdapter.notifyDataSetChanged()
            }
        }
    }
}
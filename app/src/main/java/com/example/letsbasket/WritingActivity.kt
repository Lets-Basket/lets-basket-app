package com.example.letsbasket

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.example.letsbasket.R
import org.w3c.dom.Text
import com.example.letsbasket.homeTab.HomeTab
import com.example.letsbasket.network.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WritingActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_writing)

        val title = findViewById<EditText>(R.id.title)
        val category = findViewById<EditText>(R.id.category)
        val price = findViewById<EditText>(R.id.price)
        val people = findViewById<EditText>(R.id.people)
        val deadline = findViewById<EditText>(R.id.deadline)
        val url = findViewById<EditText>(R.id.url)
        val dong = findViewById<EditText>(R.id.dong)
        val desc = findViewById<EditText>(R.id.description)
        val img = findViewById<ImageView>(R.id.img)

        val memoAddFinish = findViewById<Button>(R.id.memoAddFinish)

        val token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImlkIjoiY2hvZW5naGEifSwiaWF0IjoxNjI3NjE0MDcwLCJleHAiOjM2MDAxNjI3NjE0MDcwfQ.dbKM2KQSf5Junis4my1oA-NR34B6tUMyTN8UCO1KjQ8"
        var data = UploadData();

        memoAddFinish.setOnClickListener {
            val intent = Intent(this, HomeTab::class.java)

            data.title = title?.text.toString()
            data.category =  Integer.parseInt(category?.text.toString())
            data.price = Integer.parseInt(price?.text.toString())
            data.people = Integer.parseInt(people?.text.toString())
            data.deadline = deadline?.text.toString()
            data.url = url?.text.toString()
            data.dong = dong?.text.toString()
            data.desc = desc?.text.toString()
            data.img = "img"

            RetrofitBuilder.api.makePost(token, data).enqueue(object : Callback<UploadResponse> {
                override fun onResponse(
                    call: Call<UploadResponse>,
                    response: Response<UploadResponse>
                ) {
                    if(response.isSuccessful) {
                        Log.d("WritingTest", "연결성공")
                        var a: UploadResponse = response.body()!!
                        Log.d("WritingTest", a.room_id.toString())
                    }
                }

                override fun onFailure(call: Call<UploadResponse>, t: Throwable) {
                    Log.d("WritingTest", "실패$t")
                }

            })
            intent.putExtra("post", "list")

        }

        val intent = intent
    }

}
package com.example.letsbasket

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.example.letsbasket.R
import org.w3c.dom.Text
import com.example.letsbasket.homeTab.HomeTab
import com.example.letsbasket.login.LoginActivity
import com.example.letsbasket.network.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WritingActivity : Activity() {
    var catArray = arrayOf("과일/견과", "수산/해산물", "정육/계란", "채소", "쌀/잡곡", "유제품", "반찬/간편식", "생수/음료", "주류", "과자/빵",
    "즉석요리", "양념/소스", "화장지/위생", "청소용품", "헤어/바디", "주방/일회용품")
    var dongArray = arrayOf("청파동", "효창동", "남영동", "후암동", "원효로1동", "원효로2동", "용문동", "공덕동")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_writing)


        val title = findViewById<EditText>(R.id.title)
        val category = findViewById<Spinner>(R.id.category)
        val price = findViewById<EditText>(R.id.price)
        val people = findViewById<EditText>(R.id.people)
        val deadline = findViewById<EditText>(R.id.deadline)
        val url = findViewById<EditText>(R.id.url)
        val dong = findViewById<Spinner>(R.id.dong)
        val desc = findViewById<EditText>(R.id.description)
        val img = findViewById<ImageView>(R.id.img)

        val memoAddFinish = findViewById<Button>(R.id.memoAddFinish)

        category.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, catArray)

        var data = UploadData();

        memoAddFinish.setOnClickListener {

            Log.d("WritingTest", "여긴 뜨는데")

            //아이템 선택 리스너
            category.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    data.category = position+1
                }
            }

            dong.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    data.dong = dongArray[position]
                }
            }


            data.title = title?.text.toString()
            data.category =  4
            data.price = Integer.parseInt(price?.text.toString())
            data.people = Integer.parseInt(people?.text.toString())
            data.deadline = deadline?.text.toString()
            data.url = url?.text.toString()
            data.dong = "청파동"
            data.desc = desc?.text.toString()
            data.img = url?.text.toString()

            RetrofitBuilder.api.makePost(data).enqueue(object : Callback<UploadResponse> {
                override fun onResponse(
                    call: Call<UploadResponse>,
                    response: Response<UploadResponse>
                ) {
                    if(response.isSuccessful) {
                        Log.d("WritingTest", "연결성공")
                        var a: UploadResponse = response.body()!!
                        Log.d("WritingTest", a.room_id.toString())

                        finish()
                    }
                }

                override fun onFailure(call: Call<UploadResponse>, t: Throwable) {
                    Log.d("WritingTest", "실패$t")
                }

            })
        }
    }

}
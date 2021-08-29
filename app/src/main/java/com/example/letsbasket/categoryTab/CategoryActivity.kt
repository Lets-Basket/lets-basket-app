package com.example.letsbasket.categoryTab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.letsbasket.R
import com.example.letsbasket.network.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button)

        val auth = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImlkIjoiY2hvZW5naGEifSwiaWF0IjoxNjI5OTAwMzMxLCJleHAiOjM2MDAxNjI5OTAwMzMxfQ.SE2FTfk8NeJt7UAzTM1pVuH1fdapxVCxxxxRcizY2QE"
        val categoryID = 3
        val callGetItemsByCat = RetrofitBuilder.api.getItemByCat(auth, categoryID)

        callGetItemsByCat.enqueue(object : Callback<List<ItemsByCat>> {
            override fun onResponse(call: Call<List<ItemsByCat>>, response: Response<List<ItemsByCat>>) {
                if(response.isSuccessful()) { // <--> response.code == 200
                    // 성공 처리
                    //Toast.makeText(this, "${response.body().student.size}", Toast.LENGTH_SHORT).show()
                    Log.d("결과", "성공 : ${response.body()}")
                } else { // code == 400
                    // 실패 처리
                    Log.d("결과", "뭔가 잘못됐어 : ${response.raw()}")
                }
            }

            override fun onFailure(call: Call<List<ItemsByCat>>, t: Throwable) { // code == 500
                // 실패 처리
                Log.d("결과:", "실패 : $t")
            }
        })
    }
}
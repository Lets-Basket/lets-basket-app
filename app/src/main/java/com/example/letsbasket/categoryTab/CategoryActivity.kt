package com.example.letsbasket.categoryTab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.letsbasket.R
import com.example.letsbasket.network.RetrofitBuilder
import kotlinx.android.synthetic.main.activity_button.*
import kotlinx.android.synthetic.main.activity_item_list.*
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

class CategoryActivity : AppCompatActivity() {
    // adapter 선언
    lateinit var categoryAdapter: CategoryAdapter
    val datas = mutableListOf<ItemsByCat>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_list)

        //val categoryID = 3
        val categoryID = intent.getIntExtra("catNum", 1)
        val callGetItemsByCat = RetrofitBuilder.api.getItemByCat(categoryID)

        callGetItemsByCat.enqueue(object : Callback<List<ItemsByCat>> {
            override fun onResponse(call: Call<List<ItemsByCat>>, response: Response<List<ItemsByCat>>) {
                if(response.isSuccessful()) { // <--> response.code == 200
                    // 성공 처리
                    //Toast.makeText(this, "${response.body().student.size}", Toast.LENGTH_SHORT).show()
                    Log.d("결과", "성공 : ${response.body()}")


                    val jsonString = response.body()!!
                    initRecycler(jsonString)


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



    private fun initRecycler(e: List<ItemsByCat>){
        val categoryAdapter = CategoryAdapter(this)
        itemList.adapter = categoryAdapter

        datas.apply{
            addAll(e)

            categoryAdapter.datas = datas
            categoryAdapter.notifyDataSetChanged()
        }
    }
}
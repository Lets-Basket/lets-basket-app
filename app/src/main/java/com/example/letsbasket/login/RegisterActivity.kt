package com.example.letsbasket.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.*
import com.example.letsbasket.R
import com.example.letsbasket.manageToken.App
import com.example.letsbasket.network.RetrofitBuilder
import com.google.gson.annotations.SerializedName
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : Activity() {

    var dong_data = arrayOf("청파동", "효창동", "남영동", "후암동", "원효로1동", "원효로2동", "용문동", "공덕동")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val favoritecat: Array<Int>
        val studentcard = "imgurl"
        val name = findViewById<EditText>(R.id.edit_name)
        val studentnum = findViewById<EditText>(R.id.edit_studentnum)
        val major = findViewById<EditText>(R.id.edit_major)
        val dong = findViewById<Spinner>(R.id.edit_address)
        val latitude = 37.545920
        val longtitude = 126.964629
        val id = findViewById<EditText>(R.id.edit_id)
        val pw = findViewById<EditText>(R.id.edit_pw)
        val phonenum = findViewById<EditText>(R.id.edit_phonenum)

        // 스피너 어댑터 설정 - resource - array.xml에 있는 아이템 목록 추가하기
        //dong.adapter = ArrayAdapter.createFromResource(this, R.array.itemList, android.R.layout.simple_spinner_item)
        dong.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, dong_data)

        val btn_register2 = findViewById<Button>(R.id.btn_register2)

        var RData = RegisterRequest()

        name.text = Editable.Factory.getInstance().newEditable("이현진")
        studentnum.text = Editable.Factory.getInstance().newEditable(1710235.toString())
        major.text = Editable.Factory.getInstance().newEditable("ICT융합공학부")

        btn_register2.setOnClickListener{

            val intent = Intent(this, LoginActivity::class.java)

            //아이템 선택 리스너
            dong.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    RData.dong = dong_data[position]
                }
            }

            RData.favoritecategory = arrayOf(1, 2, 3)
            RData.studentcard = "imgurl"
            RData.name = name?.text.toString()
            RData.studentnum = Integer.parseInt(studentnum?.text.toString())
            RData.major = major?.text.toString()
            //RData.dong = dong?.text.toString()
            RData.latitude = 37.545920
            RData.longtitude = 126.964629
            RData.id = id?.text.toString()
            RData.pw = pw?.text.toString()
            RData.phonenum = phonenum?.text.toString()

            RetrofitBuilder.api.register(RData).enqueue(object : Callback<RegisterResponse> {
                override fun onResponse(
                    call: Call<RegisterResponse>,
                    response: Response<RegisterResponse>
                ) {
                    if(response.isSuccessful) {
                        Log.d("회원가입:", "성공")
                        Toast.makeText(this@RegisterActivity, "회원가입 완료", Toast.LENGTH_SHORT).show()

                        startActivity(intent)
                    }
                }
                override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                    Log.d("회원가입:", "실패$t")
                }

            })

        }
    }
}
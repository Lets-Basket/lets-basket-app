package com.example.letsbasket.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.example.letsbasket.R
import com.example.letsbasket.manageToken.App
import com.example.letsbasket.network.RetrofitBuilder
import com.google.gson.annotations.SerializedName
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //val favoritecategory: Array<Int>
        //val studentcard = "imgurl"
        val edit_name = findViewById<EditText>(R.id.edit_name)
        //val edit_studentnum = findViewById<EditText>(R.id.edit_studentnum)
        val edit_major = findViewById<EditText>(R.id.edit_major)
        val edit_dong = findViewById<EditText>(R.id.edit_address)
        val latitude = 37.545920
        val longtitude = 126.964629
        val edit_id = findViewById<EditText>(R.id.edit_id)
        val edit_pw = findViewById<EditText>(R.id.edit_pw)
        val edit_phonenum = findViewById<EditText>(R.id.edit_phonenum)

        edit_name.text = Editable.Factory.getInstance().newEditable("이현진")
        edit_studentnum.text = Editable.Factory.getInstance().newEditable("1710235")
        edit_major.text = Editable.Factory.getInstance().newEditable("ICT융합공학부")

        var data = RegisterRequest()

        val callRegister = RetrofitBuilder.api.register(data)

        btn_register2.setOnClickListener{

            val intent = Intent(this, LoginActivity::class.java)

            data.favoritecategory = arrayOf(1, 2, 3)
            data.studentcard = "imgurl"
            data.name = edit_name.text.toString()
            data.studentnum = 1710235
            data.major = edit_major.text.toString()
            data.dong = edit_dong.text.toString()
            data.latitude = latitude.toFloat()
            data.longtitude = longtitude.toFloat()
            data.id = edit_id.text.toString()
            data.pw = edit_pw.text.toString()
            data.phonenum = edit_phonenum.text.toString()

            callRegister.enqueue(object : Callback<RegisterResponse> {
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
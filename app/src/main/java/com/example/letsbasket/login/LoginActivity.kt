package com.example.letsbasket.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.letsbasket.R
import com.example.letsbasket.homeTab.HomeTab
import com.example.letsbasket.network.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val editId = findViewById<EditText>(R.id.edit_id)
        val editPw = findViewById<EditText>(R.id.edit_pw)

        val btnLogin = findViewById<Button>(R.id.btn_login)

        var data = LoginData()


        btnLogin.setOnClickListener {
            val intent = Intent(this, HomeTab::class.java)

            data.id = editId?.text.toString()
            data.pw =  editPw?.text.toString()


            RetrofitBuilder.api.login(data).enqueue(object : Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    if(response.isSuccessful) {
                        Log.d("WritingTest", "연결성공")
                        var a: LoginResponse = response.body()!!
                        Log.d("WritingTest", a.token.toString())
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Log.d("WritingTest", "실패$t")
                }

            })
            intent.putExtra("post", "list")

        }
    }
}
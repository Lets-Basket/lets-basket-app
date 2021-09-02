package com.example.letsbasket.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import com.example.letsbasket.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        edit_name.text = Editable.Factory.getInstance().newEditable("이현진")
        edit_studentnum.text = Editable.Factory.getInstance().newEditable("1710235")
        edit_major.text = Editable.Factory.getInstance().newEditable("ICT융합공학부")

        btn_register2.setOnClickListener{
            Toast.makeText(this, "회원가입 완료", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
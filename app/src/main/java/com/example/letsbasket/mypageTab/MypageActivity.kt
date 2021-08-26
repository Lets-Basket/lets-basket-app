package com.example.letsbasket.mypageTab

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.letsbasket.R
import kotlinx.android.synthetic.main.activity_button.*

class MypageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button)

        val intent = Intent(this, ItemActivity::class.java)
        testBtn.setOnClickListener{
            startActivity(intent)
        }
    }
}
package com.example.letsbasket

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class WritingActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_writing)
        val editText = findViewById<EditText>(R.id.title)
        val btn = findViewById<Button>(R.id.memoAddFinish)

        val intent = intent
    }

}
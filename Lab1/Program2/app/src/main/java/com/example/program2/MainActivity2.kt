package com.example.program2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    private lateinit var resultTv : TextView
    lateinit var goBack : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        resultTv = findViewById(R.id.result_tv)
        goBack = findViewById(R.id.btn_back)

        goBack.setOnClickListener {
            finish()
        }
    }

    override fun onStart(){
        super.onStart()
        Log.d("act2", "started activity 2")
        val result = intent.getStringExtra("result")
        if (result != null) {
            Log.d("act2", result)
        }
        resultTv.text = result
    }

}
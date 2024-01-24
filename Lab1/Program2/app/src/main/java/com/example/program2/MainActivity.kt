package com.example.program2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.OnClickListener
import android.widget.Button
import java.io.BufferedReader
import android.view.View
import android.widget.EditText
import kotlin.math.log

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var btnAdd : Button
    lateinit var btnSub : Button
    lateinit var etA : EditText
    lateinit var etB : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnAdd  = findViewById(R.id.btn_add)
        btnSub = findViewById(R.id.btn_sub)
        etA = findViewById(R.id.et_a)
        etB = findViewById(R.id.et_b)

        btnAdd.setOnClickListener(this)
        btnSub.setOnClickListener(this)
    }

    override fun onClick(v: View?){
        var a = etA.text.toString().toDouble()
        var b = etB.text.toString().toDouble()
        Log.d("debug", a.toString())
        Log.d("debug", b.toString())


        var result = 0.0
        when(v?.id){
            R.id.btn_add ->{
                result = a+b
                Log.d("debug", result.toString())
            }
            R.id.btn_sub ->{
                result = a-b
                Log.d("debug", result.toString())
            }
        }

        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("result", result.toString())
        Log.d("debug", "added to intent")
        startActivity(intent)
        Log.d("debug", "sent to intent")



    }
}
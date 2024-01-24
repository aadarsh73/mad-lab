package com.example.kotlin1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.view.View

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var btnAdd : Button
    lateinit var btnSub : Button
    lateinit var btnMult : Button
    lateinit var btnDiv : Button
    lateinit var etA : EditText
    lateinit var etB : EditText
    lateinit var resultTv: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnAdd = findViewById(R.id.btn_add)
        btnSub = findViewById(R.id.btn_sub)
        btnMult = findViewById(R.id.btn_mult)
        btnDiv= findViewById(R.id.btn_div)
        etA = findViewById(R.id.et_a)
        etB = findViewById(R.id.et_b)
        resultTv = findViewById(R.id.result_box)
        btnAdd.setOnClickListener(this)
        btnSub.setOnClickListener(this)
        btnMult.setOnClickListener(this)
        btnDiv.setOnClickListener(this)
    }

    override fun onClick(v: View?){
        var a = etA.text.toString().toDouble()
        var b = etB.text.toString().toDouble()
        var result = 0.0
        when(v?.id){
            R.id.btn_add ->{
                result = a+b
            }
            R.id.btn_sub ->{
                result= a-b
            }
            R.id.btn_mult ->{
                result = a*b
            }
            R.id.btn_div ->{
                result = a/b
            }
        }

        resultTv.text = "Result is $result"
    }
}
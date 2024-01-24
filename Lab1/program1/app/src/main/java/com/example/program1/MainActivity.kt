package com.example.program1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Lifecycle", "onCreateCalled")
    }

    override fun onStart(){
        super.onStart()
        Log.d("Lifecycle", "onStartCalled")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Lifecycle", "onResumeCalled")
    }
}
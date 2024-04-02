package com.example.program1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.program1.R

class Activity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity2)

        val vehicleDetailsTextView: TextView = findViewById(R.id.vehicleDetailsTextView)
        val confirmButton: Button = findViewById(R.id.confirmButton)
        val editButton: Button = findViewById(R.id.editButton)

        // Retrieve the vehicle details from the intent
        val vehicleDetails = intent.getStringExtra("vehicleDetails")
        vehicleDetailsTextView.text = vehicleDetails

        confirmButton.setOnClickListener {
            // Handle confirmation
            Toast.makeText(this, "Parking allotted successfully. Serial No: 12345", Toast.LENGTH_LONG).show()
            finish() // Close the activity
        }

        editButton.setOnClickListener {
            // Handle edit action
            // You can start the com.example.program1.MainActivity again or navigate to another activity for editing
            finish() // Close the activity
        }
    }
}

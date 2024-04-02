package com.example.program1

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the spinner with vehicle types
        val vehicleTypeSpinner: Spinner = findViewById(R.id.vehicleTypeSpinner)
        val vehicleTypes = arrayOf("Car", "Bike", "Truck", "Bus")
        ArrayAdapter(this, android.R.layout.simple_spinner_item, vehicleTypes).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            vehicleTypeSpinner.adapter = it
        }

        // Initialize the edit texts
        val vehicleNumberEditText: EditText = findViewById(R.id.vehicleNumberEditText)
        val rcNumberEditText: EditText = findViewById(R.id.rcNumberEditText)

        // Initialize the submit button
        val submitButton: Button = findViewById(R.id.submitButton)
        submitButton.setOnClickListener {
            val vehicleType = vehicleTypeSpinner.selectedItem.toString()
            val vehicleNumber = vehicleNumberEditText.text.toString()
            val rcNumber = rcNumberEditText.text.toString()

            // Display the entered details in a new activity or dialog for confirmation
            // For simplicity, we'll show a toast message here
            Toast.makeText(this, "Vehicle Type: $vehicleType\nVehicle Number: $vehicleNumber\nRC Number: $rcNumber", Toast.LENGTH_LONG).show()

            // Assuming the details are confirmed, show a toast message with a specific serial number
            Toast.makeText(this, "Parking allotted successfully. Serial No: 12345", Toast.LENGTH_LONG).show()
        }
        submitButton.setOnClickListener {
            val vehicleType = vehicleTypeSpinner.selectedItem.toString()
            val vehicleNumber = vehicleNumberEditText.text.toString()
            val rcNumber = rcNumberEditText.text.toString()

            // Prepare the vehicle details string
            val vehicleDetails = "Vehicle Type: $vehicleType\nVehicle Number: $vehicleNumber\nRC Number: $rcNumber"

            // Create an intent to start ConfirmationActivity
            val intent = Intent(this, Activity2::class.java)
            intent.putExtra("vehicleDetails", vehicleDetails)
            startActivity(intent)
        }
    }
}

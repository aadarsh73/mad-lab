package com.example.program2

import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.DatePicker
import android.widget.Spinner
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the spinners with source and destination
        val sourceSpinner: Spinner = findViewById(R.id.sourceSpinner)
        val destinationSpinner: Spinner = findViewById(R.id.destinationSpinner)
        val sources = arrayOf("Source 1", "Source 2", "Source 3")
        val destinations = arrayOf("Destination 1", "Destination 2", "Destination 3")
        ArrayAdapter(this, android.R.layout.simple_spinner_item, sources).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            sourceSpinner.adapter = it
        }
        ArrayAdapter(this, android.R.layout.simple_spinner_item, destinations).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            destinationSpinner.adapter = it
        }

        // Initialize the date picker
        val datePicker: DatePicker = findViewById(R.id.datePicker)

        // Initialize the toggle button
        val toggleButton: ToggleButton = findViewById(R.id.toggleButton)

        // Initialize the submit and clear buttons
        val submitButton: Button = findViewById(R.id.submitButton)
        val clearButton: Button = findViewById(R.id.clearButton)

        submitButton.setOnClickListener {
            // Retrieve the selected source, destination, and date
            val source = sourceSpinner.selectedItem.toString()
            val destination = destinationSpinner.selectedItem.toString()
            val date = "${datePicker.dayOfMonth}/${datePicker.month + 1}/${datePicker.year}"
            val journeyType = if (toggleButton.isChecked) "Round Trip" else "One-Way"

            // Create an Intent to start DetailsActivity
            val intent = Intent(this, DetailsActivity::class.java)
            // Pass the data to DetailsActivity
            intent.putExtra("source", source)
            intent.putExtra("destination", destination)
            intent.putExtra("date", date)
            intent.putExtra("journeyType", journeyType)
            // Start DetailsActivity
            startActivity(intent)
        }


        clearButton.setOnClickListener {
            // Clear the spinners and reset the date picker
            sourceSpinner.setSelection(0)
            destinationSpinner.setSelection(0)

            // Reset the toggle button to off state
            toggleButton.isChecked = false

            // Set the date in the DatePicker to the current date
            val calendar = Calendar.getInstance()
            datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), null)
        }
    }
}

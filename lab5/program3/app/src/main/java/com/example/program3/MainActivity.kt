package com.example.program3

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.DatePicker
import android.widget.Spinner
import android.widget.TimePicker
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var spinnerSource: Spinner
    private lateinit var spinnerDestination: Spinner
    private lateinit var datePicker: DatePicker
    private lateinit var timePicker: TimePicker
    private lateinit var toggleTatkal: ToggleButton
    private lateinit var buttonSubmit: Button
    private lateinit var buttonClear: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI components
        spinnerSource = findViewById(R.id.spinner_source)
        spinnerDestination = findViewById(R.id.spinner_destination)
        datePicker = findViewById(R.id.date_picker)
        timePicker = findViewById(R.id.time_picker)
        toggleTatkal = findViewById(R.id.toggle_tatkal)
        buttonSubmit = findViewById(R.id.button_submit)
        buttonClear = findViewById(R.id.button_clear)

        // Populate spinners with sample data
        val sources = arrayOf("Source 1", "Source 2", "Source 3")
        val destinations = arrayOf("Destination 1", "Destination 2", "Destination 3")
        spinnerSource.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, sources)
        spinnerDestination.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, destinations)

        // Set up button listeners
        buttonSubmit.setOnClickListener {
            val source = spinnerSource.selectedItem.toString()
            val destination = spinnerDestination.selectedItem.toString()
            val date = datePicker.year.toString() + "-" + (datePicker.month + 1) + "-" + datePicker.dayOfMonth
            val time = timePicker.hour.toString() + ":" + timePicker.minute
            val isTatkal = toggleTatkal.isChecked

            // Validate time for Tatkal tickets
            if (isTatkal && timePicker.hour < 11) {
                Toast.makeText(this, "Tatkal tickets are available only after 11:00 hours.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            // Pass data to the next activity
            val intent = Intent(this, TicketDetailsActivity::class.java)
            intent.putExtra("source", source)
            intent.putExtra("destination", destination)
            intent.putExtra("date", date)
            intent.putExtra("time", time)
            intent.putExtra("isTatkal", isTatkal)
            startActivity(intent)
        }
        buttonClear.setOnClickListener { clearForm() }
    }

    private fun submitTicket() {
        // Validate time for Tatkal tickets
        if (toggleTatkal.isChecked && timePicker.hour < 11) {
            // Show error message
            return
        }

        // Display ticket details and available trains
        // This is where you would typically navigate to another activity or fragment to display the details
    }

    private fun clearForm() {
        // Reset form fields
        spinnerSource.setSelection(0)
        spinnerDestination.setSelection(0)
        datePicker.updateDate(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH))
        timePicker.hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        timePicker.minute = Calendar.getInstance().get(Calendar.MINUTE)
        toggleTatkal.isChecked = false
    }
}

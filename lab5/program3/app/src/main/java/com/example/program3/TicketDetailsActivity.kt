package com.example.program3

import android.content.Intent
import android.os.Bundle
import kotlin.random.Random
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.DatePicker
import android.widget.Spinner
import android.widget.TextView
import android.widget.TimePicker
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class TicketDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ticket_details)

        val source = intent.getStringExtra("source")
        val destination = intent.getStringExtra("destination")
        val date = intent.getStringExtra("date")
        val time = intent.getStringExtra("time")
        val isTatkal = intent.getBooleanExtra("isTatkal", false)

        // Display ticket details
        val detailsTextView = findViewById<TextView>(R.id.detailsTextView)
        detailsTextView.text =
            "Source: $source\nDestination: $destination\nDate: $date\nTime: $time\nTatkal: $isTatkal"

        // Fetch and display available trains based on the selected time duration
        // This is a placeholder. You would typically fetch this data from a backend service or a local database.
        val availableTrains = fetchAvailableTrains(date.toString(), time.toString(), isTatkal)
        val trainsTextView = findViewById<TextView>(R.id.trainsTextView)
        trainsTextView.text = availableTrains.joinToString("\n")
    }

    fun fetchAvailableTrains(date: String, time: String, isTatkal: Boolean): List<String> {
        // Generate a random number of trains between 1 and 5
        val numberOfTrains = Random.nextInt(1, 6)
        val trainList = mutableListOf<String>()

        for (i in 1..numberOfTrains) {
            // Generate a random train name
            val trainName = "Train ${Random.nextInt(100, 999)}"
            // Generate a random departure time
            val departureTime = "${Random.nextInt(1, 24)}:${Random.nextInt(0, 60)}"
            // Generate a random arrival time
            val arrivalTime = "${Random.nextInt(1, 24)}:${Random.nextInt(0, 60)}"

            // Add the train details to the list
            trainList.add("$trainName - Departure: $departureTime, Arrival: $arrivalTime")
        }

        return trainList
    }
}
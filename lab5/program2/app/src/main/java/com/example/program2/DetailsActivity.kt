package com.example.program2

import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        // Retrieve the data from the Intent
        val source = intent.getStringExtra("source")
        val destination = intent.getStringExtra("destination")
        val date = intent.getStringExtra("date")
        val journeyType = intent.getStringExtra("journeyType")

        // Display the data in TextViews
        val textViewSource: TextView = findViewById(R.id.textViewSource)
        val textViewDestination: TextView = findViewById(R.id.textViewDestination)
        val textViewDate: TextView = findViewById(R.id.textViewDate)
        val textViewJourneyType: TextView = findViewById(R.id.textViewJourneyType)
        val backbtn = findViewById<Button>(R.id.back)

        textViewSource.text = "Source: $source"
        textViewDestination.text = "Destination: $destination"
        textViewDate.text = "Date: $date"
        textViewJourneyType.text = "Journey Type: $journeyType"
        backbtn.setOnClickListener{
            finish()
        }
    }

}

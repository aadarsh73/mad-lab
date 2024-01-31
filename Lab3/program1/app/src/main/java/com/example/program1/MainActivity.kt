package com.example.program1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val listView = findViewById<ListView>(R.id.listView)
//        val cities = arrayOf(
//            "New York", "Los Angeles", "Chicago", "Houston", "Philadelphia", "Phoenix", "San Antonio", "San Diego",
//            "Dallas", "San Jose", "Austin", "Jacksonville", "San Francisco", "Indianapolis", "Columbus", "Fort Worth",
//            "Charlotte", "Seattle", "Denver", "El Paso", "Detroit", "Washington D.C.", "Boston", "Memphis", "Nashville",
//            "Portland", "Oklahoma City", "Las Vegas", "Baltimore", "Louisville", "Milwaukee", "Albuquerque", "Tucson",
//            "Fresno", "Sacramento", "Kansas City", "Long Beach", "Mesa", "Atlanta", "Colorado Springs", "Virginia Beach",
//            "Raleigh", "Omaha", "Miami", "Oakland", "Minneapolis", "Tulsa", "Bakersfield", "Arlington", "Wichita"
//        )
//        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cities)
//        listView.adapter = adapter

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = CustomAdapter(generateItems())


        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"))
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"))
        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"))

    }
}

fun generateItems(): Array<String> {
    val items = mutableListOf<String>()
    for (i in 1..100) {
        items.add("Item $i")
    }
    return items.toTypedArray()
}


class CustomAdapter(private val dataSet: Array<String>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView

        init {
            textView = view.findViewById(R.id.textView)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.text_row_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.textView.text = dataSet[position]
    }

    override fun getItemCount() = dataSet.size
}

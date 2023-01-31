package com.example.coderswag.controller

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coderswag.R
import com.example.coderswag.adapter.CategoryRecyclerAdapter
import com.example.coderswag.services.DataService
import com.example.coderswag.utilities.EXTRA_CATEGORY

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: CategoryRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryRecyclerAdapter(this, DataService.categories) {
            val productIntent = Intent(this, ProductsActivity::class.java)
            productIntent.putExtra(EXTRA_CATEGORY, it.title)
            startActivity(productIntent)
        }
        val categoryListView: RecyclerView = findViewById(R.id.categoryListView)
        categoryListView.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        categoryListView.layoutManager = layoutManager
        categoryListView.setHasFixedSize(true)
    }
}
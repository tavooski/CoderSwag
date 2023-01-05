package com.example.coderswag.controller

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.coderswag.R
import com.example.coderswag.adapter.CategoryAdapter
import com.example.coderswag.services.DataService

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryAdapter(this, DataService.categories)

        val categoryListView: ListView = findViewById(R.id.categoryListView)
        categoryListView.adapter = adapter
    }
}
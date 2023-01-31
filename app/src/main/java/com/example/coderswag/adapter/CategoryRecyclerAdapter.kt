package com.example.coderswag.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coderswag.R
import com.example.coderswag.model.Category

class CategoryRecyclerAdapter(val context: Context, val categories: List<Category>, val itemClick: (Category) -> Unit) :
    RecyclerView.Adapter<CategoryRecyclerAdapter.Holder>() {

    inner class Holder(itemView: View, val itemClick: (Category) -> Unit) : RecyclerView.ViewHolder(itemView) {

        val categoryImage = itemView.findViewById<ImageView>(R.id.categoryImage)!!
        val categoryName = itemView.findViewById<TextView>(R.id.categoryName)!!

        fun bindCategory(category: Category, context: Context) {
            val resourceId =
                context.resources.getIdentifier(category.image, "drawable", context.packageName)
            categoryImage.setImageResource(resourceId)
            categoryName.text = category.title
            itemView.setOnClickListener { itemClick(category) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_list_item, parent, false)
        return Holder(view, itemClick)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindCategory(categories[position], context)
    }

    override fun getItemCount(): Int {
        return categories.count()
    }
}
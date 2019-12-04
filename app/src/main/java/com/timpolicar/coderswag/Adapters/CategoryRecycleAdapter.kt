package com.timpolicar.coderswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.timpolicar.coderswag.Model.Category
import com.timpolicar.coderswag.R

class CategoryRecycleAdapter(val context: Context, val categories: List<Category>) : RecyclerView.Adapter<CategoryRecycleAdapter.Holder>() {
    

    // called when new viewholders are needed. Similar to layoutinflate.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.category_list_item, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return categories.count()
    }

    //called by the recyclerview to display the data at the specified location - this is some kind of preparation
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bindCategory(categories[position], context)
    }


    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //refrencing the names and images we are going to be using - here we are getting the textView and image on our layout
        val catImage = itemView?.findViewById<ImageView>(R.id.categoryimage)
        val catName = itemView?.findViewById<TextView>(R.id.categoryname)

        fun bindCategory(category: Category, context: Context){
            val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName) //getting the image (we want) by the name from resources
            //setting the name,image on layout to the title and image in Category class
            catImage?.setImageResource(resourceId)
            catName?.text = category.title
        }
    }
}
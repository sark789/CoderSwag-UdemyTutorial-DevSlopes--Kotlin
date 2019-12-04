package com.timpolicar.coderswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.timpolicar.coderswag.Model.Category
import com.timpolicar.coderswag.R

//BaseAdapter: it is a base adapter that other adapter inherit from
class CategoryAdapter(context: Context, categories: List<Category>): BaseAdapter() {
    //these 4 need to be implemented!!

    val context = context
    val categories = categories

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val categoryView: View
        val holder: ViewHolder

        //that means it is the very first time these categoryviews are presentet/made
        if(convertView == null){
            categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null) //LayoutInflater: takes an xml file and turns it into an actual view
            holder = ViewHolder()
            //we are referencing the picture and textview in this layout to these variables and passing them into holder
            holder.catImage = categoryView.findViewById(R.id.categoryimage)
            holder.catName = categoryView.findViewById(R.id.categoryname)


            categoryView.tag = holder
        }else //if we already created this specific categoryview
        {
            //reusing the cells
            holder = convertView.tag as ViewHolder
            categoryView = convertView
        }



        //setting the corresponding item
        val category = categories[position]

        //dynamic images
        val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName) // with getIdentifier we get the actual imagename in drawable
        holder.catImage?.setImageResource(resourceId)

        //dynamic titles
        holder.catName?.text = category.title

        return categoryView
    }

    //with this we can retrieve item that is at that position
    override fun getItem(position: Int): Any {
        return categories[position]
    }

    //defines a unique ID for each row, we are not gonna be using it
    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return categories.count()
    }

    //we have created this viewholder because everytime we scrolled categoryviews were recreated, with viewHolder these categoryviews are reused, the values are saved
    private class ViewHolder {
        var catImage: ImageView? = null
        var catName: TextView? = null

    }
}
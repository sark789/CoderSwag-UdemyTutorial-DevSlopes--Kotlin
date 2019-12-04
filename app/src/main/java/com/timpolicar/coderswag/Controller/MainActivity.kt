package com.timpolicar.coderswag.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.timpolicar.coderswag.Adapters.CategoryAdapter
import com.timpolicar.coderswag.Adapters.CategoryRecycleAdapter
import com.timpolicar.coderswag.Model.Category
import com.timpolicar.coderswag.R
import com.timpolicar.coderswag.Services.DataService
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var adapter : CategoryRecycleAdapter

    //Adapter: middle man for data and views
    //RecyclerView is improved ListView! Better optimize because u have to use ViewHolder, more built in tools, but it doesnthave built in onclick listener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //old simple adapter
        //adapter = ArrayAdapter(this,
            //android.R.layout.simple_list_item_1, DataService.categories) //context, some default look (view) - how we want it to look, what are we presenting (data)


        adapter = CategoryRecycleAdapter(this, DataService.categories)
        categoryListView.adapter = this.adapter // telling listview who it needs to listen to (setting) the list adapter to this adapter that we created

//        //THIS WONT WORK FOR RECYCLER VIEW - works on listView
//        categoryListView.setOnItemClickListener { parent, view, position, id ->
//            val category = DataService.categories[position]
//            Toast.makeText(this, "You clicked on the ${category.title} cell", Toast.LENGTH_SHORT).show()
//
//        }

        //we need a layout manager for RecyclerView
        val layoutManager = LinearLayoutManager(this)
        categoryListView.layoutManager = layoutManager
        categoryListView.setHasFixedSize(true) //optimization if we know that the cards wont be resizing

    }
}

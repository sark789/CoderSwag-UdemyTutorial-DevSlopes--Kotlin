package com.timpolicar.coderswag.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.timpolicar.coderswag.Model.Category
import com.timpolicar.coderswag.R
import com.timpolicar.coderswag.Services.DataService
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var adapter : ArrayAdapter<Category>

    //Adapter: middle man for data and views
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, DataService.categories) //context, some default look (view) - how we want it to look, what are we presenting (data)
            categoryListView.adapter = this.adapter // telling listview who it needs to listen to (setting) the list adapter to this adapter that we created

    }
}

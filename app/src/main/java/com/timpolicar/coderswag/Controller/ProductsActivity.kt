package com.timpolicar.coderswag.Controller

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.timpolicar.coderswag.Adapters.ProductsAdapter
import com.timpolicar.coderswag.R
import com.timpolicar.coderswag.Services.DataService
import com.timpolicar.coderswag.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    lateinit var adapter : ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY) //unpacking the extra
        adapter = ProductsAdapter(this, DataService.getProducts(categoryType)) //passing extra here so it returns the correct list of products
        productsListView.adapter = adapter

        var spanCount = 2
        val orientation = resources.configuration.orientation
        if(orientation == Configuration.ORIENTATION_LANDSCAPE) spanCount = 3 //if we rotate the phone it will have 3 columns

        val screenSize = resources.configuration.screenWidthDp
        if(screenSize > 720) spanCount = 3 // if we running it on large phones the portrait will have 3 columns



        val layoutManager = GridLayoutManager(this, spanCount) //spanCount = number of columns
        productsListView.layoutManager = layoutManager

    }
}

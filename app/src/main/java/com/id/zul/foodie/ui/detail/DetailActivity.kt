package com.id.zul.foodie.ui.detail

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.id.zul.foodie.R
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

class DetailActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var ivItem: ImageView
    private lateinit var tvDesc: TextView
    private lateinit var tvName: TextView

    private var dataIvItem: String? = null
    private var dataTvDesc: String? = null
    private var dataTvName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        initializeToolbar()
        initializeViews()
        getData()
    }

    private fun initializeToolbar() {
        toolbar = find(R.id.toolbar)
        setSupportActionBar(toolbar)

        toolbar.title = "Detail Food"

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
    }

    private fun initializeViews() {
        ivItem = find(R.id.iv_item_detail)
        tvDesc = find(R.id.tv_item_how_to_detail)
        tvName = find(R.id.tv_item_name_detail)
    }

    private fun getData() {
        dataIvItem = intent.getStringExtra("image")
        dataTvDesc = intent.getStringExtra("desc")
        dataTvName = intent.getStringExtra("name")

        setData()
    }

    private fun setData() {
        this.let {
            Picasso
                .get()
                .load(dataIvItem)
                .into(ivItem)
        }
        tvDesc.text = dataTvDesc
        tvName.text = dataTvName
    }

}

package com.id.zul.foodie.repository

import androidx.lifecycle.LiveData
import com.id.zul.foodie.model.Foods

interface CatalogSource {

    fun getData(): LiveData<List<Foods>>

}
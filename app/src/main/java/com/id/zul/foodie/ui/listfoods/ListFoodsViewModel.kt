package com.id.zul.foodie.ui.listfoods

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.id.zul.foodie.model.Foods
import com.id.zul.foodie.repository.CatalogRepository

class ListFoodsViewModel(private val catalogRepository: CatalogRepository) : ViewModel() {

    fun getData(): LiveData<List<Foods>> = catalogRepository.getData()

}
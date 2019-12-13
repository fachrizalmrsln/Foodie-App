package com.id.zul.foodie.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.id.zul.foodie.di.Injection
import com.id.zul.foodie.repository.CatalogRepository
import com.id.zul.foodie.ui.listfoods.ListFoodsViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(private val catalogRepository: CatalogRepository) :
    ViewModelProvider.Factory {

    companion object {
        private var INSTANCE: ViewModelFactory? = null
        fun getInstance(): ViewModelFactory? {
            if (INSTANCE == null) {
                synchronized(ViewModelFactory::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = ViewModelFactory(Injection.provideRepository())
                    }
                }
            }
            return INSTANCE
        }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(ListFoodsViewModel::class.java) ->
                ListFoodsViewModel(catalogRepository) as T
            else -> throw IllegalArgumentException("Error view model from " + modelClass.name)
        }
    }
}
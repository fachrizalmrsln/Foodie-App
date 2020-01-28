package com.id.zul.foodie.di

import com.id.zul.foodie.repository.CatalogRepository
import com.id.zul.foodie.repository.RemoteRepository
import com.id.zul.foodie.ui.listfoods.ListFoodsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

object AppModule {

    val viewModelModule = module {
        single { RemoteRepository() }
        single { CatalogRepository(get()) }
        viewModel { ListFoodsViewModel(get()) }
    }

}
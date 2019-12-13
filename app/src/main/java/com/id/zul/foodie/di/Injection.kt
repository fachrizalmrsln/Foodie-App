package com.id.zul.foodie.di

import com.id.zul.foodie.repository.CatalogRepository
import com.id.zul.foodie.repository.RemoteRepository

class Injection {
    companion object {
        fun provideRepository(): CatalogRepository {
            val remoteRepository = RemoteRepository.getInstance()
            return CatalogRepository.getInstance(remoteRepository)
        }
    }
}
package com.id.zul.foodie

import android.app.Application
import com.id.zul.foodie.di.AppModule.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class FoodieApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@FoodieApp)
            modules(viewModelModule)
        }
    }
}
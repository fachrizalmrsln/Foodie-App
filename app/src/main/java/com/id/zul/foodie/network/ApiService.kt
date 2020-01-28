package com.id.zul.foodie.network

import com.id.zul.foodie.model.Foods
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("foods")
    fun getData(): Call<List<Foods>>

}
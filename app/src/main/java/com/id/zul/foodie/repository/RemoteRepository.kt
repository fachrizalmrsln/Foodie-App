package com.id.zul.foodie.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.id.zul.foodie.model.Foods
import com.id.zul.foodie.network.ApiClient
import com.id.zul.foodie.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteRepository {

    fun getData(): LiveData<List<Foods>> {
        val foodData: MutableLiveData<List<Foods>> = MutableLiveData()

        val foodCall: Call<List<Foods>> =
            ApiClient.createClient().create(ApiService::class.java)
                .getData()
        foodCall.enqueue(object : Callback<List<Foods>> {
            override fun onFailure(call: Call<List<Foods>>, t: Throwable) {
                Log.d("Network Test", "onFailure " + t.message)
                foodData.value = null
            }

            override fun onResponse(call: Call<List<Foods>>, response: Response<List<Foods>>) {
                Log.d("Network Test", "onResponse")
                response.body().let {
                    foodData.value = it
                }
            }

        })
        return foodData
    }
}
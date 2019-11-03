package com.android.assignment.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.android.assignment.api.ApiService
import com.android.assignment.model.Category
import com.android.assignment.model.Image
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val apiService: ApiService) {

    fun getImages(): MutableLiveData<List<Image>> {
        val images = MutableLiveData<List<Image>>(emptyList())
        apiService.images().enqueue(object: Callback<List<Image>>{
            override fun onFailure(call: Call<List<Image>>, t: Throwable) {
                Log.d("Repository", t.message)
            }

            override fun onResponse(call: Call<List<Image>>, response: Response<List<Image>>) {
                Log.d("Repository", response.body().toString())
                images.postValue(response.body())
            }

        })
        return images
    }

}
package com.android.assignment.api

import com.android.assignment.model.Image
import retrofit2.Call
import retrofit2.http.GET

/**
 * REST API access points
 */
interface ApiService {

    @GET(".")
    fun images(): Call<List<Image>>
}

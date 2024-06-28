package com.android.apirest

import retrofit2.http.Url
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.Response
import retrofit2.http.Headers
import retrofit2.http.Body
import retrofit2.Call

interface APIService {

    @GET
    suspend fun getDogsByBreeds(@Url url: String): Response<DogsResponse>

    @Headers("Content-Type: application/json")
    @POST("posts")
    fun addResource(@Body userData: DogInfo): Call<DogInfo>
}
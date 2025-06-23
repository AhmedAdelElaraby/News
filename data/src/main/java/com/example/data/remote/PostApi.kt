package com.example.data.remote

import com.example.domain.model.PostResponse
import retrofit2.http.GET

interface PostApi {
    @GET("r/kotlin/.json")
    suspend fun getPosts(): PostResponse
}
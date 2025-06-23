package com.example.data.repository

import com.example.data.remote.PostApi
import com.example.domain.model.PostResponse
import com.example.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PostRepositoryImpl(private val api: PostApi) : PostRepository {
   override suspend fun getPosts()=  api.getPosts()


}
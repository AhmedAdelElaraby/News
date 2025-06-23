package com.example.domain.usecase

import com.example.domain.model.PostResponse
import com.example.domain.repository.PostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetPostsUseCase(private val repository: PostRepository) {

      suspend fun getPost() = flow<PostResponse> {
            emit(repository.getPosts())
      }.flowOn(Dispatchers.IO)



}
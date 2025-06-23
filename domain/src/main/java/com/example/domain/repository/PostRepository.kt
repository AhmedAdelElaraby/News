package com.example.domain.repository

import com.example.domain.model.PostResponse
import kotlinx.coroutines.flow.Flow

interface PostRepository {
   suspend fun getPosts(): PostResponse
}
package com.example.core.utils

import com.example.domain.model.PostResponse

sealed class ApiState {
    object Loading : ApiState()
    class  Success(val data: PostResponse) : ApiState()
    class Failure(val message: String?) : ApiState()
    object Empty : ApiState()
}
package com.example.appnews.ui.screens.homescreen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.utils.ApiState
import com.example.domain.usecase.GetPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import kotlinx.coroutines.flow.catch


import javax.inject.Inject
@HiltViewModel
class PostViewModel @Inject constructor(private val post :GetPostsUseCase):ViewModel() {


    private val posts: MutableLiveData<ApiState> = MutableLiveData<ApiState>(ApiState.Empty)
    val _post:LiveData<ApiState> = posts


    fun getPost(){
        viewModelScope.launch {
            posts.value = ApiState.Loading
            post.getPost()
                .catch { e->
                    posts.value =  when(e){
                        is HttpException -> ApiState.Failure(e.message())
                        else -> ApiState.Failure(e.message!!)
                    }
                }.collect{data ->
                    posts.value = ApiState.Success(data)
                }
        }


    }














}
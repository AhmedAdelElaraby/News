package com.example.appnews.di

import com.example.domain.repository.PostRepository
import com.example.domain.usecase.GetPostsUseCase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {


    @Provides
    fun ProvideUseCase(repo: PostRepository): GetPostsUseCase {

        return GetPostsUseCase(repo)

    }

}
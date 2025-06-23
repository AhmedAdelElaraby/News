package com.example.appnews.di

import com.example.data.remote.PostApi
import com.example.data.repository.PostRepositoryImpl
import com.example.domain.repository.PostRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideRepo( api: PostApi): PostRepository {

        return PostRepositoryImpl(api)
    }



}
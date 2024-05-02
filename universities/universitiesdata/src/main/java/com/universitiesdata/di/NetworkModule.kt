package com.universitiesdata.di

import com.universitiesdata.remote.EndPoint
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providesUniversitiesEndPoint(retrofit: Retrofit): EndPoint {
        return retrofit.create(EndPoint::class.java)
    }

}
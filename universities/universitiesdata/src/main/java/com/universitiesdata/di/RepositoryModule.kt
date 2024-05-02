package com.universitiesdata.di

import com.coredomain.repo.PreferenceRepository
import com.universitiesdata.remote.EndPoint
import com.universitiesdata.repo_impl.RepositoryImpl
import com.universitiesdomain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(
        endPoint: EndPoint, preferenceRepository: PreferenceRepository
    ): Repository = RepositoryImpl(
        endPoint
    )

}
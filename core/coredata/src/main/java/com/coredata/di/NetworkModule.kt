package com.coredata.di


import android.util.Log
import com.coredata.util.NetworkConstants
import com.coredata.util.NetworkConstants.CONTENT_TYPE
import com.coredata.util.NetworkConstants.NETWORK_TIMEOUT
import com.coredomain.repo.PreferenceRepository
import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.internal.platform.Platform
import retrofit2.Converter
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Provides
    @Singleton
    fun converterFactory(): Converter.Factory {
        val json = Json {
            ignoreUnknownKeys = true
            isLenient = true
        }
        return json.asConverterFactory(CONTENT_TYPE)
    }

    @Provides
    @Singleton
    fun loggingInterceptor(): LoggingInterceptor {
        return LoggingInterceptor.Builder().setLevel(Level.BASIC).log(Platform.INFO)
            .request("Request").response("Response").build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        loggingInterceptor: LoggingInterceptor,
        preferenceRepository: PreferenceRepository,
    ): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(loggingInterceptor).addInterceptor { chain ->
            val original = chain.request()

            val requestBuilder = original.newBuilder().header(
                NetworkConstants.LANGUAGE, getLanguage(preferenceRepository)
            ).header(
                NetworkConstants.AUTHORIZATION, getToken(preferenceRepository)
            )
            val request = requestBuilder.build()
            return@addInterceptor chain.proceed(request)
        }.connectTimeout(NETWORK_TIMEOUT, TimeUnit.MILLISECONDS)
            .readTimeout(NETWORK_TIMEOUT, TimeUnit.MILLISECONDS).build()
    }

    private fun getLanguage(preferenceRepository: PreferenceRepository): String {
        var language: String = "ar"
        return language
    }

    private fun getToken(preferenceRepository: PreferenceRepository): String {
        var token: String = ""
        return if (token.isNotEmpty()) {
            Log.i("getToken", "getToken: $token")
            "${NetworkConstants.BEARER}$token"
        } else {
            Log.i("getToken", "getToken:")
            ""
        }
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        converterFactory: Converter.Factory,
        @StringsModule.RemoteBaseUrl baseUrl: String
    ): Retrofit {
        return Retrofit.Builder().addConverterFactory(converterFactory)
            .addCallAdapterFactory(CoroutineCallAdapterFactory()).client(okHttpClient)
            .baseUrl(baseUrl).build()
    }

    @Provides
    @Singleton
    fun provideCoroutineContext(): CoroutineContext = Dispatchers.IO
}

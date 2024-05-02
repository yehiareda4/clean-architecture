package com.coredata.local

import android.util.Log
import com.coredomain.util.DataState
import com.coredomain.util.FirebaseExceptions
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withTimeout

const val CACHE_TIMEOUT = 30000L

suspend fun <T> safeCacheCall(
    dispatcher: CoroutineDispatcher,
    cacheCall: suspend () -> T?
): Flow<DataState<T>> = flow {

    withTimeout(CACHE_TIMEOUT) {
        val response = cacheCall.invoke()

        if (response != null) {
            emit(DataState.Success(response))
        } else {
            Log.i("cashException", "safeCacheCall: error " )
            emit(DataState.Error(FirebaseExceptions.UnknownException))
        }
    }

}.onStart {
    emit(DataState.Loading)
}.catch {
    Log.i("cashException", "safeCacheCall: " + it.toString())
    Log.i("cashException", "safeCacheCall: " + it.message)
    Log.i("cashException", "safeCacheCall: " + it.cause)
    when (it) {
        is TimeoutCancellationException -> {
            emit(DataState.Error(CacheExceptions.TimeoutException))
        }
        else -> {
            emit(DataState.Error(CacheExceptions.UnknownException))
        }
    }
}.flowOn(dispatcher)
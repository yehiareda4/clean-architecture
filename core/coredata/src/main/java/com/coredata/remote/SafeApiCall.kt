package com.coredata.remote

import com.coredata.util.NetworkConstants.NETWORK_TIMEOUT
import com.coredomain.entity.AnyResponse
import com.coredomain.entity.BaseResponse
import com.coredomain.util.DataState
import com.coredomain.util.FailRequestCode.BLOCKED
import com.coredomain.util.FailRequestCode.EXCEPTION
import com.coredomain.util.FailRequestCode.FAIL
import com.coredomain.util.FailRequestCode.UN_AUTH
import com.coredomain.util.NetworkExceptions
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withTimeout
import kotlinx.serialization.json.Json
import retrofit2.HttpException
import java.io.IOException
import java.net.UnknownHostException

suspend fun <T> safeApiCall(
    apiCall: suspend () -> T
): Flow<DataState<T>> = flow {
    withTimeout(NETWORK_TIMEOUT) {
        val response = apiCall.invoke()
        emit(handleSuccess(response))
    }
}.onStart {
    emit(DataState.Loading)
}.catch {
    emit(handleError(it))
}.flowOn(Dispatchers.IO)

fun <T> handleSuccess(response: T): DataState<T> {
    if (response != null) return DataState.Success(response)
    return DataState.Error(NetworkExceptions.UnknownException)
}

fun <T> handleError(it: Throwable): DataState<T> {
    it.printStackTrace()
    return when (it) {
        is TimeoutCancellationException -> {
            DataState.Error(NetworkExceptions.TimeoutException)
        }

        is UnknownHostException -> {
            DataState.Error(NetworkExceptions.ConnectionException)
        }

        is IOException -> {
            DataState.Error(NetworkExceptions.UnknownException)
        }

        is HttpException -> {
            DataState.Error(convertErrorBody(it))
        }

        else -> {
            DataState.Error(NetworkExceptions.UnknownException)
        }
    }
}

fun convertErrorBody(throwable: HttpException): Exception {
    return try {
        val errorBody = throwable.response()?.errorBody()?.charStream()
        val jsonString = errorBody?.buffered().use { it?.readText() }
        if (!jsonString.isNullOrBlank()) {
            val response: BaseResponse<AnyResponse> = Json.decodeFromString(jsonString)
            when (throwable.code()) {
                FAIL -> NetworkExceptions.CustomException(response.msg)
                UN_AUTH, BLOCKED -> NetworkExceptions.AuthorizationException
                EXCEPTION -> NetworkExceptions.ServerException
                else -> NetworkExceptions.UnknownException
            }
        } else {
            NetworkExceptions.UnknownException
        }
    } catch (e: Exception) {
        NetworkExceptions.UnknownException
    }
}
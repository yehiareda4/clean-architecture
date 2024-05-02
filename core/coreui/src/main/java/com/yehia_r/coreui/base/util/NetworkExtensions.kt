package com.aait.coreui.base.util

import com.aait.coreui.R
import com.coredomain.util.DataState
import com.coredomain.util.NetworkExceptions

interface NetworkExtensionsActions {
    fun onLoad(showLoading: Boolean) {

    }

    fun onCommonError(exceptionMsgId: Int) {

    }

    fun onWorkingTime() {

    }

    fun onShowSuccessToast(msg: String?) {

    }

    fun onFail(msg: String?) {

    }

    fun authorizationFail() {

    }

    fun block() {

    }

    fun authorizationNeedActive(msg: String) {

    }
}

fun <T> DataState<T>.applyCommonSideEffects(
    networkExtensionsActions: NetworkExtensionsActions,
    showLoading: Boolean = true,
    showSuccessToast: Boolean = false,
    onSuccess: (T) -> Unit = {},
) {
    when (this) {
        is DataState.Loading -> {
            if (showLoading) networkExtensionsActions.onLoad(true)
        }

        is DataState.Success -> {
            networkExtensionsActions.onLoad(false)
            if (showSuccessToast) networkExtensionsActions.onShowSuccessToast("")
            onSuccess(this.data)
        }

        is DataState.Error -> {
            networkExtensionsActions.onLoad(false)
            handleError(networkExtensionsActions, throwable)
        }

        DataState.Idle -> {
            networkExtensionsActions.onLoad(false)
        }
    }
}

fun handleError(
    networkExtensionsActions: NetworkExtensionsActions,
    throwable: Throwable,
) {
    when (throwable) {
        is NetworkExceptions.AuthorizationException -> {
            networkExtensionsActions.authorizationFail()
        }

        is NetworkExceptions.NeedActiveException -> {
            networkExtensionsActions.authorizationNeedActive(throwable.msg)
        }

        is NetworkExceptions.ConnectionException -> {
            networkExtensionsActions.onCommonError(R.string.no_internet_connection)
        }

        is NetworkExceptions.CustomException -> {
            networkExtensionsActions.onFail(throwable.msg)
        }

        else -> {
            networkExtensionsActions.onCommonError(throwable.getIsCommonException())
        }
    }
}

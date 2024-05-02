package com.aait.coreui.base.util

import com.aait.coreui.R
import com.coredomain.util.NetworkExceptions

fun Throwable.getIsCommonException(): Int {
    when (this) {
        is NetworkExceptions.ConnectionException -> {
            return R.string.no_internet_connection
        }

        is NetworkExceptions.NotFoundException -> {
            return R.string.something_went_wrong
        }

        is NetworkExceptions.ServerException -> {
            return R.string.something_went_wrong
        }

        is NetworkExceptions.TimeoutException -> {
            return R.string.no_internet_connection
        }

        is NetworkExceptions.UnknownException -> {
            return R.string.something_went_wrong
        }

        else -> {
            return R.string.something_went_wrong
        }
    }
}
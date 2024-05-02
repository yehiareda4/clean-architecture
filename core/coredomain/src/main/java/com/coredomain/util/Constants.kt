package com.coredomain.util

import java.util.*

object Constants {

    const val TAG = "AppDebug" // Tag for logs

    const val NETWORK_TIMEOUT = 300000L
    const val BEARER = "Bearer "
    const val AUTHORIZATION = "Authorization"
    const val LANGUAGE = "lang"

    val language: String
        get() {
            return Locale.getDefault().language
        }
}

object NetworkParams {

}


object MethodType {
    const val PATCH = "patch"
    const val PUT = "put"
}

object ResponseStatus {
    const val SUCCESS = "success"
    const val NEED_ACTIVATE = "needActive"
    const val FAILED = "fail"
    const val ACTIVE = "active"
    const val NOT_ACTIVE = "waitingApproval"
    const val BLOCK = "blocked"
    const val PENDING = "pending"
    const val UN_AUTH = "unauthenticated"
    const val EXCEPTION = "exception"
}

object FailRequestCode {
    const val FAIL = 400
    const val UN_AUTH = 419
    const val BLOCKED = 423
    const val EXCEPTION = 500
}
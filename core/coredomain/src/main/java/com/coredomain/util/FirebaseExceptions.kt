package com.coredomain.util

sealed class FirebaseExceptions : Exception() {
    object UnknownException : FirebaseExceptions()
    object NotFoundException : FirebaseExceptions()
    data class CustomException(val msg: String) : FirebaseExceptions()
}
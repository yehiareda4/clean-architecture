package com.coredata.local

sealed class CacheExceptions : Exception() {
    object UnknownException : CacheExceptions()
    object TimeoutException : CacheExceptions()
}
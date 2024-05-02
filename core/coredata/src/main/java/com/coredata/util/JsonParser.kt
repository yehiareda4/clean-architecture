package com.coredata.util

import java.lang.reflect.Type

interface JsonParser {
    fun <T> fromJson(json: String, type: T): List<T>?
    fun <T> toJson(obj: T, type: T): String?
}
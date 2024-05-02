package com.universitiesdata

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

val json = Json { ignoreUnknownKeys = true }

inline fun <reified T> T.toJson(): String {
    return json.encodeToString(this)
}

inline fun <reified T : Any> String.fromJson(): T {
    return json.decodeFromString(this)
}


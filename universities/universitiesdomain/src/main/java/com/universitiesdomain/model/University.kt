package com.universitiesdomain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class University(
    @SerialName("domains") val domains: MutableList<String> = ArrayList(),
    @SerialName("web_pages") val webPages: MutableList<String> = ArrayList(),
    @SerialName("state-province") val state: String? = "",
    @SerialName("name") val name: String,
    @SerialName("country") val country: String,
    @SerialName("alpha_two_code") val alphaTwoCode: String
) : java.io.Serializable
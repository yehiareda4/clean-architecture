package com.universitiesdomain.model

import kotlinx.serialization.SerialName
import java.io.Serializable

@kotlinx.serialization.Serializable
data class Universities(
    @SerialName("universities") val universities: MutableList<University> = ArrayList(),
) : Serializable
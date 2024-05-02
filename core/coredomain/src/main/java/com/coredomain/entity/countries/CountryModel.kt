package com.coredomain.entity.countries

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CountryModel(
    val id:Int, val name:String, val key:String?, val image : String = "", val currency:String = "",
    @SerialName("currency_code")val currencyCode: String = "", var isSelected:Boolean = false
)
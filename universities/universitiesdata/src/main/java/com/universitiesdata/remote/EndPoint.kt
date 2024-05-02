package com.universitiesdata.remote

import com.universitiesdomain.model.University
import retrofit2.http.GET
import retrofit2.http.Query

interface EndPoint {

    @GET("search")
    suspend fun getUniversities(
        @Query("country") country: String = "United Arab Emirates",
    ): MutableList<University>

}

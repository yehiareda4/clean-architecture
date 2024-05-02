package com.coredomain.repo

import kotlinx.coroutines.flow.Flow


interface PreferenceRepository {

    suspend fun getUniversities():Flow<String>
    suspend fun setUniversities(universities: String)

}
package com.universitiesdomain.repository

import com.coredomain.util.DataState
import com.universitiesdomain.model.University
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getUniversities(): Flow<DataState<MutableList<University>>>
}
package com.universitiesdomain.usecase

import com.coredomain.util.DataState
import com.universitiesdomain.model.University
import com.universitiesdomain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UniversitiesUseCase @Inject constructor(
    private val repository: Repository,
) {
    suspend operator fun invoke(
    ): Flow<DataState<MutableList<University>>> = flow {
        emitAll(repository.getUniversities())
    }
}
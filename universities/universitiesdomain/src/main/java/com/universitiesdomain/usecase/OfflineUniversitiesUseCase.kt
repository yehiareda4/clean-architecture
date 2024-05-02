package com.universitiesdomain.usecase

import com.coredomain.repo.PreferenceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OfflineUniversitiesUseCase @Inject constructor(
    private val preferenceRepository: PreferenceRepository
) {
    suspend operator fun invoke(): Flow<String>  = preferenceRepository.getUniversities()

}
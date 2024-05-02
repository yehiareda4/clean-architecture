package com.universitiesdomain.usecase

import com.coredomain.repo.PreferenceRepository
import javax.inject.Inject

class SetOfflineUniversitiesUseCase @Inject constructor(
    private val preferenceRepository: PreferenceRepository
) {
    suspend operator fun invoke(list: String) = preferenceRepository.setUniversities(list)
}
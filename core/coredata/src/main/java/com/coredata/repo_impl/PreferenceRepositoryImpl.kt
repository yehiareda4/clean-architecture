package com.coredata.repo_impl

import com.coredata.datasource.PreferenceDataSource
import com.coredata.local.PreferenceConstants
import com.coredomain.repo.PreferenceRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PreferenceRepositoryImpl @Inject constructor(
    private val preferenceDataSource: PreferenceDataSource
) : PreferenceRepository {


    override suspend fun getUniversities(): Flow<String> = flow {
        preferenceDataSource.getValue(PreferenceConstants.UNIVERSITIES, "")
            .collect {
                emit(it as String)
            }
    }

    override suspend fun setUniversities(universities: String) {
        return preferenceDataSource.setValue(PreferenceConstants.UNIVERSITIES, universities)
    }
}
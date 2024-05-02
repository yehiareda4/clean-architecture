package com.universitiesdata.repo_impl

import com.coredata.remote.safeApiCall
import com.universitiesdata.remote.EndPoint
import com.universitiesdomain.repository.Repository
import javax.inject.Inject


class RepositoryImpl @Inject constructor(
    private val endPoint: EndPoint
) : Repository {

    override suspend fun getUniversities() = safeApiCall {
        endPoint.getUniversities()
    }


}
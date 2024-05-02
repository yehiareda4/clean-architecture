package com.coredata.datasource

import kotlinx.coroutines.flow.Flow

interface SocketDataSource {
    fun connectToSocket(): Flow<Boolean>
    fun disconnectSocket()
    fun openChannel(channel: String): Flow<Pair<String, List<String>>>
    fun emit(type: String, data: MutableMap<Any, Any>)
}
package com.coredata.datasource_impl

import android.util.Log
import com.coredata.datasource.SocketDataSource
import io.socket.client.Socket
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import org.json.JSONObject
import javax.inject.Inject

@OptIn(DelicateCoroutinesApi::class)
class SocketDataSourceImpl @Inject constructor(private val socket: Socket) : SocketDataSource {

    private val connectFlow = MutableStateFlow(false)
    private val messagesFlow = MutableStateFlow(Pair("", emptyList<String>()))

    init {
        socket.on(Socket.EVENT_CONNECT) {
            Log.e("TAG", "EVENT_CONNECT : ")
            GlobalScope.launch { connectFlow.emit(true) }
        }
        socket.on(Socket.EVENT_DISCONNECT) {
            Log.e("TAG", "EVENT_DISCONNECT : ")
            GlobalScope.launch { connectFlow.emit(false) }
        }
        socket.on(Socket.EVENT_CONNECT_ERROR) {
            Log.e("TAG", "EVENT_CONNECT_ERROR : ")
            connectToSocket()
        }
    }

    override fun connectToSocket(): Flow<Boolean> = flow {
        if (!socket.connected()) socket.connect()
        else GlobalScope.launch { connectFlow.emit(true) }
        connectFlow.collect { emit(it) }
    }

    override fun disconnectSocket() {
        if (socket.connected()) socket.disconnect()
        GlobalScope.launch { messagesFlow.emit(Pair("", emptyList())) }
    }

    override fun openChannel(channel: String) = flow {
        socket.off(channel)
        socket.on(channel) {
            GlobalScope.launch {
                it.map { it.toString() }.let { messagesFlow.emit(Pair(channel, it)) }
            }
        }
        messagesFlow.collect { emit(it) }
    }

    override fun emit(type: String, data: MutableMap<Any, Any>) {
        if (socket.connected()) socket.emit(type, JSONObject(data.toMap()))
        else GlobalScope.launch {
            connectToSocket().collect {
                if (it) {
                    socket.emit(type, JSONObject(data as Map<*, *>))
                }
            }
        }
    }
}
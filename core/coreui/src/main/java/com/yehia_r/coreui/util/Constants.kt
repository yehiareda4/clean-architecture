package com.aait.coreui.util

import java.time.format.DateTimeFormatter
import java.util.*

object Constants {

    const val TAG = "AppDebug" // Tag for logs
    const val DEBUG = true // enable logging

    val language: String
        get() {
            return Locale.getDefault().language
        }

    const val LAT = "lat"
    const val LNG = "lng"
    const val ADDRESS = "address"
    const val ADDRESS_AR = "address_ar"
    const val ADDRESS_EN = "address_en"
    const val CITY_AR = "city_ar"
    const val CITY_EN = "city_en"
    const val PLACE_AR = "place_ar"
    const val PLACE_EN = "place_en"
    const val DESC = "desc"
    const val DATA_TRAN = "data"
    const val KEY = "key"
    const val ARABIC = "ar"
    const val ENGLISH = "en"
    object ChatTypes {
        const val TEXT = "text"
        const val FILE = "file"
        const val MAP = "map"
        const val SOUND = "sound"
        const val IMAGE = "image"
        const val VIDEO = "video"
        const val VOICE_CALL = "voice_call"
        const val VIDEO_CALL = "video_call"
    }

    object SocketIOKeys {
        const val VIDEO_CALL = false
    }

    object BlockTypes {
        const val BLOCK_USER = "BLOCK_USER"
        const val BLOCKED = "BLOCKED"
        const val YOU_BLOCKED = "YOU_BLOCKED"
    }

    object ChatKeys {
        const val ENTER_CHAT = "enterChat"
        const val ADD_USER = "addUser"
        const val VIDEO_VOICE_CALL = "call"
        const val EXIT_CHAT = "exitChat"
        const val SEND_MESSAGE = "sendMessage"
        const val NEW_MESSAGE_LISTENER = "sendMessageRes"
    }

    object AddUserKeys {
        const val SENDER_ID = "senderId"
        const val USER_TYPE = "user_type"
        const val CONVERSATION_ID = "room_id"
        const val USER_ID = "user_id"
    }

    object VideoCallKeys {
        const val SENDER_ID = "senderId"
        const val RECEIVER_ID = "receiverId"
        const val CONVERSATION_ID = "conversationId"
        const val STATUS = "status"
        const val VIDEO_CALL_TYPE = "type"
        const val ANSWER_SECOND = "answerSecond"
        const val MINUTES = "minutes"
    }

    object CallStatus {
        const val START = "start"
        const val END_CALL = "endCall"
        const val ANSWER_CALL = "answerCall"
    }

    object SendMessageKeys {
        const val USER_ID = "userId"
        const val ROOM_ID = "roomId"
        const val CONVERSATION_ID = "room_id"
        const val SENDER_ID = "sender_id"
        const val LANG = "lang"
        const val SENDER_NAME = "senderName"
        const val SENDER_TYPE = "sender_type"
        const val RECEIVER_TYPE = "receiver_type"
        const val SENDER_AVATAR = "avatar"
        const val RECEIVER_ID = "receiver_id"
        const val MESSAGE_BODY = "body"
        const val MESSAGE = "message"
        const val TYPE = "type"
        const val MESSAGE_FILE_NAME = "name"
        const val SOUND_DURATION = "duration"

        const val PROVIDER = "Provider"
        const val USER = "User"
        const val POST_ID = "post_id"
        const val POST_TYPE = "post_type"
    }

    object MessagesTypes {
        // receiver
        const val SENDER_TXT = 10
        const val RECEIVER_IMAGE = 11
        const val RECEIVER_FILE = 11
        const val SENDER_SHARE_POST = 12

        // sender
        const val RECEIVER_TXT = 20
        const val SENDER_IMAGE = 21
        const val SENDER_FILE = 21
        const val RECEIVER_SHARE_POST = 22

        const val DATE = 5
    }

    object RemoteMessagesTypes {
        const val TEXT = "text"
        const val IMAGE = "image"
        const val POST = "sharePost"
        const val DATE = "date"
        const val FILE = "file"
    }
}
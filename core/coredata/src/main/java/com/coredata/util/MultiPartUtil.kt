package com.coredata.util

import android.net.Uri
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.MultipartBody.Part.Companion.createFormData
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File

object MultiPartUtil {

    fun convertStringToPart(stringToConvert: String): RequestBody {
        return stringToConvert
            .toRequestBody("text/plain".toMediaTypeOrNull())
    }

    fun String.toMultiPart(): RequestBody {
        return convertStringToPart(this)
    }

    fun MutableList<String>?.toMultiPart(): MutableList<RequestBody>? {
        val list = mutableListOf<RequestBody>()
        return if (this != null) {
            for (i in this)
                list.add(i.toMultiPart())
            list
        } else
            null
    }

    fun prepareFilePart(
        partName: String,
        fileUri: Uri
    ): MultipartBody.Part {
        val file = File(fileUri.path!!)
        val requestFile = file
            .asRequestBody("*/*".toMediaTypeOrNull())
        return createFormData(partName, file.name, requestFile)
    }


    fun prepareFilePart(
        partName: String,
        path: String
    ): MultipartBody.Part {
        val file = File(path)
        val requestFile = file.asRequestBody("*/*".toMediaTypeOrNull())
        return createFormData(partName, file.name, requestFile)
    }

    fun preparePDFPart(
        partName: String,
        file: File
    ): MultipartBody.Part {
        val requestFile = file
            .asRequestBody("pdf/*".toMediaTypeOrNull())
        return createFormData(partName, file.name, requestFile)
    }

    fun prepareAudioPart(
        partName: String,
        path: String
    ): MultipartBody.Part {
        val file = File(path)
        val requestFile = file
            .asRequestBody("audio/*".toMediaTypeOrNull())
        return createFormData(partName, file.name, requestFile)
    }


    fun prepareVideoPart(
        partName: String,
        path: String
    ): MultipartBody.Part {
        val file = File(path)
        val requestFile = file
            .asRequestBody("video/mp4".toMediaTypeOrNull())
        return createFormData(partName, file.name, requestFile)
    }


    fun convertFileToMultipart(path: String?, key: String): MultipartBody.Part? {

        return if (path != null) {
            val file = File(path)
            val parse = "image/png".toMediaTypeOrNull()
            val requestBody: RequestBody = file.asRequestBody(parse)
            val body: MultipartBody.Part =
                createFormData(key, file.name, requestBody)

            body
        } else {
            null
        }
    }



}
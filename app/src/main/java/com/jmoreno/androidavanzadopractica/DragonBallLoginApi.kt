package com.jmoreno.androidavanzadopractica

import android.provider.Settings.Global.getString
import android.util.Log
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

const val TOKEN ="am1vcmVub2NhcnJlcm9AaG90bWFpbC5jb206UmVhbG1hZHJpZDE0"

interface DragonBallLoginApi {

    @POST("api/auth/login")
    //@Headers("Authorization: Basic $TOKEN")

    suspend fun getToken(@Header("Authorization") authorization: String): String
    fun getHeader(credential: String): Header
}

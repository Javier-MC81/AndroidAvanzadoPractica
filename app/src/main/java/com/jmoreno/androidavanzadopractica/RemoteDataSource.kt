package com.jmoreno.androidavanzadopractica

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val api: DragonBallLoginApi){

    suspend fun getToken(credential: String): String {
        return api.getToken("$credential")
    }

}
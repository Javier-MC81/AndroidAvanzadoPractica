package com.jmoreno.androidavanzadopractica

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject

class Repository @Inject constructor(private val remoteDataSource: RemoteDataSource){

    suspend fun getToken(credential: String): String {
        return remoteDataSource.getToken(credential)
    }
}
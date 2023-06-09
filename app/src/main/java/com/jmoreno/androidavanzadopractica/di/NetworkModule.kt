package com.jmoreno.androidavanzadopractica.di

import com.jmoreno.androidavanzadopractica.DragonBallLoginApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    /*@Provides
    fun providesMoshiToLogin(): Moshi {
        val moshi = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
        return moshi
    }

    @Provides
    fun providesOkHttpToLogin(): OkHttpClient {
        val okhttp = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT).apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build()
        return okhttp
    }
    @Provides
    fun providesRetrofitToLogin(okHttpClient : OkHttpClient, moshi: Moshi): Retrofit {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://dragonball.keepcoding.education/")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
            .build()
        return retrofit
    }
    @Provides
    fun providesLoginApi(retrofit : Retrofit): DragonBallLoginApi {
        val api = retrofit.create(DragonBallLoginApi::class.java)
        return api
    }*/
}
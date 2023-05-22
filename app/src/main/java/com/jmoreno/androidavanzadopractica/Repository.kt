package com.jmoreno.androidavanzadopractica

class Repository {
    private val remoteDataSource = RemoteDataSource()

    suspend fun getToken(credential: String): String {
        return remoteDataSource.getToken(credential)
    }
}
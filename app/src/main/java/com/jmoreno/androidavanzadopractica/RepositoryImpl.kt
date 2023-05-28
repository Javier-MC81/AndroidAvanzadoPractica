package com.jmoreno.androidavanzadopractica

import com.jmoreno.androidavanzadopractica.remoteLogin.RemoteDataSource
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource) : Repository{

    override suspend fun getToken(credential: String): String {
        return remoteDataSource.getToken(credential)
    }
}
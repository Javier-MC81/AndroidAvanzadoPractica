package com.jmoreno.androidavanzadopractica.remote

import com.jmoreno.androidavanzadopractica.DragonBallLoginApi
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val api: DragonBallLoginApi){

    suspend fun getToken(credential: String): String {
        return api.getToken("$credential")
    }

}
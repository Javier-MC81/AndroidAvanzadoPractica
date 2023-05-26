package com.jmoreno.androidavanzadopractica.remoteHeroes

import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST


interface DragonBallHeroesApi {
    @POST("api/heros/all")
    //@Headers("Authorization: Bearer $TOKEN")
    suspend fun getHeros(@Header("Authorization") authorization: String,@Body getHerosRequestBody: GetHerosRequestBody): List<GetHerosResponse>
}
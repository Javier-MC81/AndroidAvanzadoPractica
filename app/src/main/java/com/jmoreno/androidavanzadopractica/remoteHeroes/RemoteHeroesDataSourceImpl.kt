package com.jmoreno.androidavanzadopractica.remoteHeroes

import javax.inject.Inject

class RemoteHeroesDataSourceImpl @Inject constructor(private val api: DragonBallHeroesApi): RemoteHeroesDataSource {

    override suspend fun getHeros(token: String?): List<GetHerosResponse> {
        return api.getHeros("Bearer $token",GetHerosRequestBody())

    }
}
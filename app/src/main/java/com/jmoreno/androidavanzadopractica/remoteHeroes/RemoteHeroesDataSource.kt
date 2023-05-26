package com.jmoreno.androidavanzadopractica.remoteHeroes

interface RemoteHeroesDataSource {
    suspend fun getHeros(token: String?): List<GetHerosResponse>
}
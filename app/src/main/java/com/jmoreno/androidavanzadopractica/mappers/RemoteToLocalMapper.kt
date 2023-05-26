package com.jmoreno.androidavanzadopractica.mappers

import com.jmoreno.androidavanzadopractica.local.LocalSuperhero
import com.jmoreno.androidavanzadopractica.remoteHeroes.GetHerosResponse
import javax.inject.Inject

class RemoteToLocalMapper @Inject constructor(){

    fun mapGetHeroResponse(getHerosResponses: List<GetHerosResponse>): List<LocalSuperhero> {
        return getHerosResponses.map { mapGetHeroResponse(it) }
    }

    fun mapGetHeroResponse(getHerosResponse: GetHerosResponse): LocalSuperhero {
        return LocalSuperhero(getHerosResponse.id, getHerosResponse.name, false)
    }
}

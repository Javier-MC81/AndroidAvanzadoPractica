package com.jmoreno.androidavanzadopractica.mappers

import com.jmoreno.androidavanzadopractica.local.LocalSuperhero
import com.jmoreno.androidavanzadopractica.ui.model.Superhero
import javax.inject.Inject

class LocalToPresentationMapper @Inject constructor() {

    fun mapLocalSuperheros(localSuperheros: List<LocalSuperhero>): List<Superhero> {
        return localSuperheros.map { mapLocalSuperheros(it) }
    }

    fun mapLocalSuperheros(getHerosResponse: LocalSuperhero): Superhero {
        return Superhero(getHerosResponse.id, getHerosResponse.name)
    }
}

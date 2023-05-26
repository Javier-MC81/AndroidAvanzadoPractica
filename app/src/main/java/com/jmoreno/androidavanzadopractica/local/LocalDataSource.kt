package com.jmoreno.androidavanzadopractica.local

interface LocalDataSource {
    suspend fun getHeros(): List<LocalSuperhero>

    suspend fun insertHero(localSuperhero: LocalSuperhero)

    suspend fun insertHeros(localSuperheros: List<LocalSuperhero>)
}

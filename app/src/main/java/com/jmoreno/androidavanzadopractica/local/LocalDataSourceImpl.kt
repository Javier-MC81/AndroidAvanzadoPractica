package com.jmoreno.androidavanzadopractica.local

import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val dao: SuperheroDAO): LocalDataSource {

    override suspend fun getHeros(): List<LocalSuperhero>{
        return dao.getAll()
    }

    override suspend fun insertHero(localSuperhero: LocalSuperhero){
        dao.insertAllList(listOf(localSuperhero))
    }

    override suspend fun insertHeros(localSuperheros: List<LocalSuperhero>){
        dao.insertAllList(localSuperheros)
    }

}
package com.jmoreno.androidavanzadopractica.remoteHeroes

import com.jmoreno.androidavanzadopractica.local.LocalDataSource
import com.jmoreno.androidavanzadopractica.mappers.LocalToPresentationMapper
import com.jmoreno.androidavanzadopractica.mappers.RemoteToLocalMapper
import com.jmoreno.androidavanzadopractica.ui.model.Superhero
import javax.inject.Inject

class RepositoryHeroesImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteHeroesDataSource,
    private val localToPresentationMapper: LocalToPresentationMapper,
    private val remoteToLocalMapper: RemoteToLocalMapper,
): Repository {

    override suspend fun getHeros(token: String?): List<Superhero> {
        if (localDataSource.getHeros().isEmpty()) {
            val remoteSuperheros = remoteDataSource.getHeros(token)
            localDataSource.insertHeros(remoteToLocalMapper.mapGetHeroResponse(remoteSuperheros))
        }
        return localToPresentationMapper.mapLocalSuperheros(localDataSource.getHeros())
    }
}
package com.jmoreno.androidavanzadopractica.remoteHeroes

import com.jmoreno.androidavanzadopractica.local.LocalDataSource
import com.jmoreno.androidavanzadopractica.local.LocalDataSourceImpl
import com.jmoreno.androidavanzadopractica.remote.RemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryHeroesModule {
    @Binds
    abstract fun bindsRepository(repositoryImpl: RepositoryHeroesImpl): Repository

    @Binds
    abstract fun bindsLocalDataSource(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource

    @Binds
    abstract fun bindsRemoteDataSource(remoteDataSourceImpl: RemoteHeroesDataSourceImpl): RemoteHeroesDataSource
}
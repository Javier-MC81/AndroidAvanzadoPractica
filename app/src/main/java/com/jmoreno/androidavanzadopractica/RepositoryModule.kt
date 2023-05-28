package com.jmoreno.androidavanzadopractica

import com.jmoreno.androidavanzadopractica.remoteLogin.RemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    companion object{
        @Provides
        fun providesRepositoryImpl(remoteDataSource: RemoteDataSource): RepositoryImpl {
            return RepositoryImpl(remoteDataSource)
        }
    }
    @Binds
    abstract fun bindRepository(
        repositoryImpl: RepositoryImpl
    ): Repository
}
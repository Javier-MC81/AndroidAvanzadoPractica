package com.jmoreno.androidavanzadopractica.remoteHeroes

import android.content.Context
import androidx.room.Room
import com.jmoreno.androidavanzadopractica.local.SuperheroDAO
import com.jmoreno.androidavanzadopractica.local.SuperheroDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    fun providesSuperheroDatabase(@ApplicationContext context: Context): SuperheroDatabase {
        val db = Room.databaseBuilder(
            context,
            SuperheroDatabase::class.java, "superhero-db"
        ).build()
        return db
    }

    @Provides
    fun providesDao(db: SuperheroDatabase): SuperheroDAO {
        val dao = db.superheroDao()
        return dao
    }

}

package com.jmoreno.androidavanzadopractica.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [LocalSuperhero::class], version = 1)
abstract class SuperheroDatabase : RoomDatabase() {
    abstract fun superheroDao(): SuperheroDAO
}

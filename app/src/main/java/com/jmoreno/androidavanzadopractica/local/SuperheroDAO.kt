package com.jmoreno.androidavanzadopractica.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SuperheroDAO {
    @Query("SELECT * FROM superheros")
    suspend fun getAll(): List<LocalSuperhero>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllVararg(vararg users: LocalSuperhero)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllList(users: List<LocalSuperhero>)

    @Delete
    suspend fun delete(user: LocalSuperhero)
}

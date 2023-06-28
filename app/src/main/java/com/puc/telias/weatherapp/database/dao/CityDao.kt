package com.puc.telias.weatherapp.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.puc.telias.weatherapp.database.entities.City
import kotlinx.coroutines.flow.Flow

@Dao
interface CityDao {
    @Query("""SELECT * FROM cities""")
    fun getAll(): Flow<List<City>>

    @Query("""SELECT * FROM cities WHERE code = :code""")
    fun getByCode(code: Int): City?

    @Insert
    fun insertAll(vararg city: City)

}
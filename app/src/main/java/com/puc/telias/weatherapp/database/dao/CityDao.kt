package com.puc.telias.weatherapp.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.puc.telias.weatherapp.database.entities.City

@Dao
interface CityDao {
    @Query("""SELECT * FROM cities""")
    fun getAll(): List<City>

    @Insert
    fun insertAll(vararg city: City)

}
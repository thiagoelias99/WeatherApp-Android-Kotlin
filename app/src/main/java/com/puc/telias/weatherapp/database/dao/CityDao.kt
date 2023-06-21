package com.puc.telias.weatherapp.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.puc.telias.weatherapp.models.City as CityApp
import com.puc.telias.weatherapp.database.entities.City as CityDB

@Dao
interface CityDao {
    @Query("""SELECT * FROM cities""")
    fun getAll(): List<CityDB>

    @Insert
    fun insertAll(vararg city: CityDB)

//    @Delete
//    fun delete(user: City)
}
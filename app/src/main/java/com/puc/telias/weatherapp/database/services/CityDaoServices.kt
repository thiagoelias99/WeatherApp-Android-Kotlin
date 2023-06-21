package com.puc.telias.weatherapp.database.services

import android.content.Context
import android.util.Log
import com.puc.telias.weatherapp.database.configuration.AppDatabase
import com.puc.telias.weatherapp.database.dao.CityDao
import java.util.UUID
import com.puc.telias.weatherapp.database.entities.City as CityDb
import com.puc.telias.weatherapp.models.City as CityApp

class CityDaoServices(context: Context) {
    val cityDao: CityDao = AppDatabase.getConnection(context).cityDao()

    fun insertAll(vararg cities: CityApp) {
        cities.forEach { city ->
            run {
                Log.i("ThiagoDebug", "insertAll: $city")
                cityDao.insertAll(
                    CityDb(
                        uuid = UUID.randomUUID(),
                        code = city.id,
                        name = city.nome,
                        state = city.estado
                    )
                )
            }
        }
    }
}
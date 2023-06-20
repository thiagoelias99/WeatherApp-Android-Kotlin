package com.puc.telias.weatherapp.services

import android.util.Log
import com.puc.telias.weatherapp.models.City
import com.puc.telias.weatherapp.webclient.apiService

class CityServices {
    suspend fun getCities(cityName: String = ""): List<City>{
        try {
            if (cityName.length === 0){
                return emptyList()
            }
            return apiService.getCities(cityName)

        } catch (e: Exception) {
            return emptyList()
        }
    }
}
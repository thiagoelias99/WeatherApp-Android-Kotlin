package com.puc.telias.weatherapp.services

import com.puc.telias.weatherapp.models.City
import com.puc.telias.weatherapp.webclient.apiService

class CityServices {
    suspend fun searchCities(cityName: String = ""): List<City>{
        try {
            if (cityName.length === 0){
                return emptyList()
            }
            return apiService.searchForCities(cityName)

        } catch (e: Exception) {
            return emptyList()
        }
    }

    suspend fun addCityToDatabase(code: Int){

    }
}
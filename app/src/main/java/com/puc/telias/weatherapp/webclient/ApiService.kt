package com.puc.telias.weatherapp.webclient

import com.puc.telias.weatherapp.models.City
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("cidade/{cityName}")
    suspend fun getCities(@Path("cityName") cityName: String = ""): List<City>
}
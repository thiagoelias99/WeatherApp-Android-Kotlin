package com.puc.telias.weatherapp.webclient

import com.puc.telias.weatherapp.models.City
import com.puc.telias.weatherapp.webclient.Models.WeatherForecast
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("cidade/{cityName}")
    suspend fun searchForCities(@Path("cityName") cityName: String = ""): List<City>
    @GET("clima/previsao/{cityCode}")
    suspend fun getCityInfo(@Path("cityCode") cityCode: Int): WeatherForecast
}
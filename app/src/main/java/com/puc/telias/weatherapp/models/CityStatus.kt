package com.puc.telias.weatherapp.models

import java.util.UUID

data class CityStatus(
    val uuid: UUID,
    val code: Int,
    val name: String,
    val maxTemperature: Float,
    val minTemperature: Float,
    val condition: String
) {
}
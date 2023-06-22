package com.puc.telias.weatherapp.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date
import java.util.UUID

@Entity(tableName = "cities")
data class City (
    @PrimaryKey val code: Int,
    val name: String,
    val state: String,
    val updatedAt: String? = null,
    val date: String? = null,
    val conditionCode: String? = null,
    val conditionDescription: String? = null,
    val minTemperature: Int? = null,
    val maxTemperature: Int? = null,
    val uvIndex: Int? = null
)
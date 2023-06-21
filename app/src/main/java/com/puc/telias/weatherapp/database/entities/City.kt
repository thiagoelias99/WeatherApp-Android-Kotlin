package com.puc.telias.weatherapp.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "cities")
data class City (
    @PrimaryKey val uuid: UUID,
    val code: Int,
    val name: String,
    val state: String
)
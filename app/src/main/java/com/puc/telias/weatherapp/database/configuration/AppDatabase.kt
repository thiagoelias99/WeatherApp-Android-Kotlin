package com.puc.telias.weatherapp.database.configuration

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.puc.telias.weatherapp.database.dao.CityDao
import com.puc.telias.weatherapp.database.entities.City

@Database(entities = [City::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cityDao(): CityDao

    companion object {
        @Volatile private var db: AppDatabase? = null
        fun getConnection(context: Context): AppDatabase {
            return db ?: Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "weatherapp.db"
            ).build().also {
                db = it
            }
        }
    }
}
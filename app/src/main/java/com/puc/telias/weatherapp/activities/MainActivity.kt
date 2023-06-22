package com.puc.telias.weatherapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.puc.telias.weatherapp.R
import com.puc.telias.weatherapp.database.configuration.AppDatabase
import com.puc.telias.weatherapp.database.dao.CityDao
import com.puc.telias.weatherapp.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private val TAG = "CoroutinesTest"

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val fab = binding.fab
        fab.setOnClickListener {
            Intent(this, AddCityActivity::class.java).run {
                startActivity(this)
            }
        }

        val cityDao: CityDao = AppDatabase.getConnection(this).cityDao()
        lifecycleScope.launch {
            val cities = cityDao.getAll()
            delay(10000)
            Log.i(TAG, "Cities: $cities")
        }
    }
}
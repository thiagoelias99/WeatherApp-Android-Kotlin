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
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
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

        val fluxo: Flow<Int> = flow {
            repeat(100) {
                emit(it)
                delay(1000)
            }
        }

        lifecycleScope.launch {
            cityDao.getAll().collect{
                Log.i(TAG, "Cities: $it")
            }
        }

        //lifecycleScope.launch {
        //    fluxo.collect {
        //        Log.i(TAG, "onCreate: $it")
        //    }
        //}

    }
}
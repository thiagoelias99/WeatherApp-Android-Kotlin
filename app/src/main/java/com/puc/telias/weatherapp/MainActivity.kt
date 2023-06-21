package com.puc.telias.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.puc.telias.weatherapp.adapters.CityListAdapter
import com.puc.telias.weatherapp.database.configuration.AppDatabase
import com.puc.telias.weatherapp.database.dao.CityDao
import com.puc.telias.weatherapp.databinding.ActivityMainBinding
import com.puc.telias.weatherapp.models.City
import com.puc.telias.weatherapp.services.CityServices
import com.puc.telias.weatherapp.webclient.apiService
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val citiesAdapter by lazy {
        CityListAdapter(context = this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        searchCityConfiguration()
        recyclerViewConfiguration()
        updateCitiesList()
    }

    fun updateCitiesList() {
        lifecycleScope.launch {
            val cities = CityServices().getCities(binding.editTextSearchCity.text.toString())
            citiesAdapter.update(cities)
        }
    }

    fun searchCityConfiguration() {
        binding.editTextSearchCity.addTextChangedListener(object : TextWatcher {
            private val handler = Handler()
            private var runnable: Runnable? = null
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                runnable?.let { handler.removeCallbacks(it) }
            }

            override fun afterTextChanged(s: Editable?) {
                runnable = Runnable {
                    updateCitiesList()
                }
                handler.postDelayed(runnable!!, 300) //
            }
        })
    }

    private fun recyclerViewConfiguration() {
        binding.recyclerView.run {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = citiesAdapter
        }
    }
}
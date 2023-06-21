package com.puc.telias.weatherapp.activities

import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.puc.telias.weatherapp.adapters.AddCityAdapter
import com.puc.telias.weatherapp.database.services.CityDaoServices
import com.puc.telias.weatherapp.databinding.ActivityAddCityBinding
import com.puc.telias.weatherapp.services.CityServices
import kotlinx.coroutines.launch

class AddCityActivity : AppCompatActivity() {
    val TAG = "MainActivity"

    private val binding by lazy {
        ActivityAddCityBinding.inflate(layoutInflater)
    }

    private val citiesAdapter by lazy {
        AddCityAdapter(context = this)
    }
    
    private val cityDaoServices: CityDaoServices by lazy{
        CityDaoServices(context = this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        searchCityConfiguration()
        recyclerViewConfiguration()
        updateCitiesList()
        
        val lista = cityDaoServices.getAll()
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
            layoutManager = LinearLayoutManager(this@AddCityActivity)
            adapter = citiesAdapter
        }
    }
}
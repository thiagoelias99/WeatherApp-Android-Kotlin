package com.puc.telias.weatherapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.puc.telias.weatherapp.R
import com.puc.telias.weatherapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val fab = binding.fab
        fab.setOnClickListener {
            Intent(this, AddCityActivity::class.java).run{
                startActivity(this)
            }
        }
    }
}
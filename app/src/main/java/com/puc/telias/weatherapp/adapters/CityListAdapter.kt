package com.puc.telias.weatherapp.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.puc.telias.weatherapp.R
import com.puc.telias.weatherapp.databinding.RecyclerItemCityBinding
import com.puc.telias.weatherapp.models.City

class CityListAdapter(
    private val context: Context,
    cities: List<City> = emptyList()
) : RecyclerView.Adapter<CityListAdapter.ViewHolder>() {

    private val cities = cities.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RecyclerItemCityBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val city = cities[position]
        holder.bind(city)
    }

    override fun getItemCount(): Int = cities.size

    inner class ViewHolder(binding: RecyclerItemCityBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: City) {
            val city = itemView.findViewById<TextView>(R.id.city_name)
            val state = itemView.findViewById<TextView>(R.id.city_state)

            city.text = item.nome
            state.text = item.estado
        }
    }

    fun update(cities: List<City>) {
        this.cities.clear()
        this.cities.addAll(cities)
        notifyDataSetChanged()
    }
}
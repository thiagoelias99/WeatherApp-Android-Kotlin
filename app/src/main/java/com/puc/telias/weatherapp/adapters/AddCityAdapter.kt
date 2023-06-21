package com.puc.telias.weatherapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.puc.telias.weatherapp.R
import com.puc.telias.weatherapp.database.services.CityDaoServices
import com.puc.telias.weatherapp.databinding.RecyclerAddCityBinding
import com.puc.telias.weatherapp.models.City

class AddCityAdapter(
    private val context: Context,
    cities: List<City> = emptyList()
) : RecyclerView.Adapter<AddCityAdapter.ViewHolder>() {

    private val cities = cities.toMutableList()
    private val citiesDaoServices = CityDaoServices(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RecyclerAddCityBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val city = cities[position]
        holder.bind(city)
    }

    override fun getItemCount(): Int = cities.size

    inner class ViewHolder(binding: RecyclerAddCityBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: City) {
            val city = itemView.findViewById<TextView>(R.id.city_name)
            val state = itemView.findViewById<TextView>(R.id.city_state)

            city.text = item.nome
            state.text = item.estado
        }

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION){
                    val clickedCity = cities[position]
                    citiesDaoServices.insertAll(clickedCity)
                    Toast.makeText(context, "Clicou em ${clickedCity.nome}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun update(cities: List<City>) {
        this.cities.clear()
        this.cities.addAll(cities)
        notifyDataSetChanged()
    }
}